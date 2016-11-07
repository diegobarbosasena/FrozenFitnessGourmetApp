package br.com.frozenfitnessgourmet.app;

/**
 * Created by 15160046 on 28/10/2016.
 */

public class Pedido {

    private String imagemPrato;
    private String nomePrato;
    private String nomeCategoriaPrato;


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
}
