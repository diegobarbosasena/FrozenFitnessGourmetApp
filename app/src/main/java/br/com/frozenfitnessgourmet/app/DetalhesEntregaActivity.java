package br.com.frozenfitnessgourmet.app;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class DetalhesEntregaActivity extends AppCompatActivity {

    private ListView listDetalheEntregar;
    Context context;


    EntregaDetalheAdapter entregarDAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_entrega);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;

        listDetalheEntregar = (ListView) findViewById(R.id.lstDetalheEntregar);

        ArrayList<Entregar> lstdetalhesentrega = new ArrayList<>();

        //lstentregar.add(new Entregar("", "Titulo", "Amanda", "Rua, 150", "Jandira - SP"));
        //lstentregar.add(new Entregar("", "Titulo2", "Amanda2", "Rua, 1502", "Jandira - SP2"));

        entregarDAdapter = new EntregaDetalheAdapter(this, R.layout.list_detalhe_entregar, lstdetalhesentrega);



        new ObtemDetalheEntrega().execute();


    }

    private class ObtemDetalheEntrega extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            String link = getString(R.string.link)+"/API/obtem_list_entregar.php?codUsuario="+ Sessao.usuarioLogado.getCodUsuario();

            boolean acessarInternet = true;

            HttpRequest http = HttpRequestFabric.getHttpRequest(acessarInternet);

            String json = http.getJson(link);

            return json;

        }
        // onPostExecute displays the results of the AsyncTask.


        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


            String titulo ="Efetuando Login";
            String mensagem = "Aguarde...";
            boolean indeterminado =true;
            boolean podeCancelar = false;

            progressDialog = ProgressDialog
                    .show(context,
                            titulo,
                            mensagem,
                            indeterminado,
                            podeCancelar
                    );
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            Log.i("Json", s);


            if(s !=null) {
                Gson g = new Gson();
                Entregar[] entregar = g.fromJson(s, Entregar[].class);


                entregarDAdapter.clear();
                entregarDAdapter.addAll(entregar);

                listDetalheEntregar.setAdapter(entregarDAdapter);


            }
        }


    }

}
