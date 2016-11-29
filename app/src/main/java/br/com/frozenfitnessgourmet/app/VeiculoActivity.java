package br.com.frozenfitnessgourmet.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class VeiculoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TabHost tabHost;
    private ListView listEntregar;


    EntregarAdapter entregarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculo);

        listEntregar = (ListView) findViewById(R.id.lstEntregar);

        ArrayList<Entregar> lstentregar = new ArrayList<>();

        lstentregar.add(new Entregar("", "Titulo", "Amanda", "Rua, 150", "Jandira - SP"));
        lstentregar.add(new Entregar("", "Titulo2", "Amanda2", "Rua, 1502", "Jandira - SP2"));

        entregarAdapter = new EntregarAdapter(this, R.layout.entrega_list_item, lstentregar);
        listEntregar.setAdapter(entregarAdapter);


        listEntregar.setOnItemClickListener(VeiculoActivity.this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Entregar e =  entregarAdapter.getItem(position);
        Intent intent = new Intent(this, DetalhesEntregaActivity.class);
        intent.putExtra("entregar", e);
        startActivity(intent);

    }
}
