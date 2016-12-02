package br.com.frozenfitnessgourmet.app;

/**
 * Created by 15160046 on 02/12/2016.
 */

public class Localizacao {
    private int codVeiculoTransp;
    private String latitude;
    private String longitude;

    public int getCodVeiculoTransp() {
        return codVeiculoTransp;
    }

    public void setCodVeiculoTransp(int codVeiculoTransp) {
        this.codVeiculoTransp = codVeiculoTransp;
    }


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
