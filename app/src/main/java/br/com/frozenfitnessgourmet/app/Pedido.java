package br.com.frozenfitnessgourmet.app;

import java.io.Serializable;

/**
 * Created by 15160046 on 28/10/2016.
 */

public class Pedido implements Serializable{

    private String imagemPrato;
    private String nomePrato;
    private String nomeCategoriaPrato;
    private double precoPrato;
    private String caloria;
    private int codStatus;


    public Pedido(String fotoPedido, String nomePedido, String categoriaPedido) {
        this.setImagemPrato(fotoPedido);
        this.setNomePrato(nomePedido);
        this.setNomeCategoriaPrato(categoriaPedido);
    }

    public Pedido() {
    }


    public String getImagemPrato() {
        return imagemPrato;
    }

    public void setImagemPrato(String imagemPrato) {
        this.imagemPrato = imagemPrato;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getNomeCategoriaPrato() {
        return nomeCategoriaPrato;
    }

    public void setNomeCategoriaPrato(String nomeCategoriaPrato) {
        this.nomeCategoriaPrato = nomeCategoriaPrato;
    }

    public double getPrecoPrato() { return precoPrato; }

    public void setPrecoPrato(double precoPrato) { this.precoPrato = precoPrato; }

    public String getCaloria() { return caloria; }

    public void setCaloria(String caloria) { this.caloria = caloria; }

    public int getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(int codStatus) {
        this.codStatus = codStatus;
    }
}
