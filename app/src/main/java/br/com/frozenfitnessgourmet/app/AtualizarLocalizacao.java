package br.com.frozenfitnessgourmet.app;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by 15160046 on 02/12/2016.
 */
public class AtualizarLocalizacao extends AsyncTask<Void, Void, Void> {

    int idCaminhao;
    double latitude;
    double longitude;
    Context context;

    public AtualizarLocalizacao(int idCaminhao, double latitude, double longitude, Context context) {

        this.context = context;
        this.idCaminhao = idCaminhao;
        this.latitude = latitude;
        this.longitude = longitude;
    }



    @Override

    protected Void doInBackground(Void... params) {

        try {
            String link = context.getString(R.string.link)+"/API/obtem_localizacao.php";
            link += "?idCaminhao="+ idCaminhao;
            link += "&latitude=" +latitude ;
            link += "&longitude=" +longitude ;

            Conexao.get(link);

            Log.d("localizacao", link);
        }catch (Exception ex){

            Log.d("localizacao", ex.getMessage());

        }

        return null;
    }
}
