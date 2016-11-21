package br.com.frozenfitnessgourmet.app;

/**
 * Created by 15160046 on 21/11/2016.
 */

public class LoginUsuario {
    private int codUsuario;
    private String usuario;
    private String tipo;

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
