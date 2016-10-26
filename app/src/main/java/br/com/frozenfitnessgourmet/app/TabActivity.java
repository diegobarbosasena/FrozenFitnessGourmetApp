package br.com.frozenfitnessgourmet.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;

/**
 * Created by 15160046 on 25/10/2016.
 */

public class TabActivity extends AppCompatActivity {

    private TabHost tabHost;


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

        TabHost.TabSpec spec2  = tabHost.newTabSpec("Outro");
        spec2.setContent(R.id.tab3);
        spec2.setIndicator("Outro");
        tabHost.addTab(spec2);

        tabHost.setOnTabChangedListener(new AnimatedTabHostListener(this, tabHost));
    }
}
