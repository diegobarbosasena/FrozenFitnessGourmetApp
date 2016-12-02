package br.com.frozenfitnessgourmet.app;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class VeiculoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView listEntregar;
    Context context;



    EntregarAdapter entregarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculo);

        context = this;

        listEntregar = (ListView) findViewById(R.id.lstEntregar);

        ArrayList<Entregar> lstentregar = new ArrayList<>();

        //lstentregar.add(new Entregar("", "Titulo", "Amanda", "Rua, 150", "Jandira - SP"));
        //lstentregar.add(new Entregar("", "Titulo2", "Amanda2", "Rua, 1502", "Jandira - SP2"));

        entregarAdapter = new EntregarAdapter(this, R.layout.entrega_list_item, lstentregar);

        listEntregar.setOnItemClickListener(VeiculoActivity.this);

        new ObtemEntregar().execute();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Entregar e =  entregarAdapter.getItem(position);
        Intent intent = new Intent(this, DetalhesEntregaActivity.class);
        intent.putExtra("entregar", e);
        startActivity(intent);

    }

    private class ObtemEntregar extends AsyncTask<String, Void, String> {
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


                entregarAdapter.clear();
                entregarAdapter.addAll(entregar);

                listEntregar.setAdapter(entregarAdapter);


            }
        }


        }
    }


