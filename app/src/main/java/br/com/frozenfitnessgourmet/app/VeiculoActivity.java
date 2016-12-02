package br.com.frozenfitnessgourmet.app;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
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

    LocationManager locationManager;

    EntregarAdapter entregarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculo);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        context = this;

        listEntregar = (ListView) findViewById(R.id.lstEntregar);

        int tempoAtualizacao = 0;
        int distancia = 10;

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1);


        }

        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                tempoAtualizacao, distancia, new GPSListener()
        );

        ArrayList<Entregar> lstentregar = new ArrayList<>();

        //lstentregar.add(new Entregar("", "Titulo", "Amanda", "Rua, 150", "Jandira - SP"));
        //lstentregar.add(new Entregar("", "Titulo2", "Amanda2", "Rua, 1502", "Jandira - SP2"));

        entregarAdapter = new EntregarAdapter(this, R.layout.entrega_list_item, lstentregar);

        listEntregar.setOnItemClickListener(VeiculoActivity.this);

        new ObtemEntregar().execute();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private class GPSListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {

            int idCaminhao = Sessao.usuarioLogado.getCodUsuario();
            double latitude=location.getLatitude();
            double longitude=location.getLongitude();

            new AtualizarLocalizacao(idCaminhao, latitude, longitude, context).execute();

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
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
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MainActivity.fechar=true;
    }
    }


