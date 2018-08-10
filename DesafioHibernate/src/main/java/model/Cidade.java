package model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Cidade {

    @Id
    @GeneratedValue
    private String nome_cidade;
    private String estado;
    private Integer qtdPopulacao;

    public String getNome_cidade() {
        return nome_cidade;
    }

    public void setNome_cidade(String nome_cidade) {
        this.nome_cidade = nome_cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getQtdPopulacao() {
        return qtdPopulacao;
    }

    public void setQtdPopulacao(Integer qtdPopulacao) {
        this.qtdPopulacao = qtdPopulacao;
    }

    @Override
    public String toString() {
        return this.nome_cidade + " " + this.estado;
    }
}
