package br.com.frozenfitnessgourmet.app;

import java.io.Serializable;

/**
 * Created by 15160046 on 18/11/2016.
 */

public class Entregar implements Serializable{
    private String nomePrato;
    private String nomeCategoriaPrato;
    private String imagemPrato;
    private String nomeCliente;
    private String logradouro;
    private String numero;
    private String nomeCidade;
    private String recebidoPor;
    private String cpfRecebido;
    private String uf;

    public Entregar(String nomePrato, String nomeCliente, String logradouro, String nomeCidade, String uf, String nomeCategoriaPrato, String imagemPrato) {
        this.setNomePrato(nomePrato);
        this.setNomeCliente(nomeCliente);
        this.setLogradouro(logradouro);
        this.setNomeCidade(nomeCidade);
        this.setUf(uf);
        this.setNomeCategoriaPrato(nomeCategoriaPrato);
        this.setImagemPrato(imagemPrato);

    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getRecebidoPor() {
        return recebidoPor;
    }

    public void setRecebidoPor(String recebidoPor) {
        this.recebidoPor = recebidoPor;
    }

    public String getCpfRecebido() {
        return cpfRecebido;
    }

    public void setCpfRecebido(String cpfRecebido) {
        this.cpfRecebido = cpfRecebido;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNomeCategoriaPrato() {
        return nomeCategoriaPrato;
    }

    public void setNomeCategoriaPrato(String nomeCategoriaPrato) {
        this.nomeCategoriaPrato = nomeCategoriaPrato;
    }

    public String getImagemPrato() {
        return imagemPrato;
    }

    public void setImagemPrato(String imagemPrato) {
        this.imagemPrato = this.imagemPrato;
    }
}
