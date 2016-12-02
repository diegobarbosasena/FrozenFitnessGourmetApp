package br.com.frozenfitnessgourmet.app;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

/**
 * Created by 15160046 on 02/12/2016.
 */

public class ObterLocalizacaoAPI extends AsyncTask<Void, Void, Localizacao> {

    private int idCaminhao;
    private GoogleMap mMap;
    Context context;

    static Marker marker;


    public ObterLocalizacaoAPI(int idCaminhao, GoogleMap googleMap, Context context) {
        this.idCaminhao = idCaminhao;
        this.mMap = googleMap;
        this.context = context;
    }

    @Override
    protected Localizacao doInBackground(Void... params) {
//http://10.107.134.68/gps/obterlocalizacao.php?idCaminhao=1

        try {
            String link = context.getString(R.string.link)+"/API/ontem_localizacao.pgp";
            link += "?idCaminhao=" + idCaminhao;

            String json = Conexao.get(link);

            Localizacao local = new Gson().fromJson(json, Localizacao.class);

            return local;
        }catch (Exception ex){

            Log.d("ObterLocalizacaoAPI", ex.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(Localizacao localizacao) {
        super.onPostExecute(localizacao);

        if(localizacao != null) {


            if(marker!=null){
                marker.remove();
                Log.d("ObterLocalizacaoAPI", "marker removido");
            }else{
                Log.d("ObterLocalizacaoAPI", "marker não removido");
            }


            LatLng pontoAtual = new LatLng(Double.parseDouble(localizacao.getLatitude()), Double.parseDouble(localizacao.getLongitude()));

            marker = mMap.addMarker(new MarkerOptions().position(pontoAtual));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(pontoAtual));


            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(pontoAtual).zoom(18).tilt(30).build();

            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


            Log.d("ObterLocalizacaoAPI", localizacao.getLatitude() + " - " + localizacao.getLongitude());
        }
    }
}
