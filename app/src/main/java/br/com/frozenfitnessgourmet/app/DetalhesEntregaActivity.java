package br.com.frozenfitnessgourmet.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class DetalhesEntregaActivity extends AppCompatActivity {

    private ListView listDetalheEntregar;


    EntregarAdapter entregarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_entrega);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listDetalheEntregar = (ListView) findViewById(R.id.lstDetalheEntregar);

        ArrayList<Entregar> lstdetalheentregar = new ArrayList<>();

        lstdetalheentregar.add(new Entregar("", "Titulo", "Amanda", "Rua, 150", "Jandira - SP"));
        lstdetalheentregar.add(new Entregar("", "Titulo2", "Amanda2", "Rua, 1502", "Jandira - SP2"));

        entregarAdapter = new EntregarAdapter(this, R.layout.list_detalhe_entregar, lstdetalheentregar);
        listDetalheEntregar.setAdapter(entregarAdapter);


    }

}
