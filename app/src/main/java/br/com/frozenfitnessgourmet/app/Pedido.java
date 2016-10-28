package br.com.frozenfitnessgourmet.app;

/**
 * Created by 15160046 on 28/10/2016.
 */

public class Pedido {

    private String fotoPedido;
    private String nomePedido;
    private String categoriaPedido;


    public Pedido(String fotoPedido, String nomePedido, String categoriaPedido) {
        this.fotoPedido = fotoPedido;
        this.nomePedido = nomePedido;
        this.categoriaPedido = categoriaPedido;
    }

    public Pedido(){}


    public String getFotoPedido() {
        return fotoPedido;
    }

    public void setFotoPedido(String fotoPedido) {
        this.fotoPedido = fotoPedido;
    }

    public String getNomePedido() {
        return nomePedido;
    }

    public void setNomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
    }

    public String getCategoriaPedido() {
        return categoriaPedido;
    }

    public void setCategoriaPedido(String categoriaPedido) {
        this.categoriaPedido = categoriaPedido;
    }
}
