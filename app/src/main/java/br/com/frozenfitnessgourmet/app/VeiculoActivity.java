package br.com.frozenfitnessgourmet.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class VeiculoActivity extends AppCompatActivity {

    private TabHost tabHost;
    private ListView listEntregar;


    EntregarAdapter entregarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculo);

        ArrayList<Entregar> lstentregar = new ArrayList<>();

        listEntregar = (ListView) findViewById(R.id.lstEntregar);

        lstentregar.add(new Entregar("", "Titulo", "Amanda", "Rua, 150", "Jandira - SP"));

        entregarAdapter = new EntregarAdapter(this, R.layout.entreda_list_item, lstentregar);
        listEntregar.setAdapter(entregarAdapter);




    }
}
