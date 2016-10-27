package br.com.frozenfitnessgourmet.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TabHost;

import static android.R.id.tabcontent;
import static java.security.AccessController.getContext;

/**
 * Created by 15160046 on 25/10/2016.
 */

public class TabActivity extends AppCompatActivity {

    private TabHost tabHost;
    private FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("Pendente");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Pendente");
        tabHost.addTab(spec);

        TabHost.TabSpec spec1  = tabHost.newTabSpec("Histórico");
        spec1.setContent(R.id.tab2);
        spec1.setIndicator("Histórico");
        tabHost.addTab(spec1);

        tabHost.setOnTabChangedListener(new AnimatedTabHostListener(this, tabHost));



        }


    }

