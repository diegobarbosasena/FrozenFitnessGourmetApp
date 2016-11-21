package br.com.frozenfitnessgourmet.app;

import java.util.Date;

/**
 * Created by 15160046 on 18/11/2016.
 */

public class Entregar {
    private String nomePrato;
    private String nomeCliente;
    private String logradouro;
    private String numero;
    private String nomeCidade;
    private String nomeEstado;
    private String recebidoPor;
    private String cpfRecebido;

    public Entregar(String nomePrato, String nomeCliente, String logradouro, String nomeCidade, String nomeEstado) {
        this.setNomePrato(nomePrato);
        this.setNomeCliente(nomeCliente);
        this.setLogradouro(logradouro);
        this.setNomeCidade(nomeCidade);
        this.setNomeEstado(nomeEstado);
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

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
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
}
