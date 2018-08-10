/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biancalins.model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author bianca.lins
 */
@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable {

    @EmbeddedId
    private VeiculoId id;

    @Column(name = "veiculo_marca", length = 50, nullable = false)
    private String marca;

    @Column(name = "veiculo_modelo", length = 50, nullable = false)
    private String modelo;

    @Column(name = "veiculo_ano", nullable = false)
    private Integer ano;

    @Column(name = "tipo_combustivel", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TipoCombustivel tipoCombustivel;

    @ManyToOne
    @JoinColumn(name = "id_proprietario", referencedColumnName = "id")
    private Proprietario proprietario;

    /**
     * @return the id
     */
    public VeiculoId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(VeiculoId id) {
        this.id = id;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the ano
     */
    public Integer getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    /**
     * @return the tipoCombustivel
     */
    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    /**
     * @param tipoCombustivel the tipoCombustivel to set
     */
    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.id + " " + this.marca + " "
                + this.modelo + " " + this.ano + " "
                + this.tipoCombustivel + " " + this.proprietario;
    }

    /**
     * @return the proprietario
     */
    public Proprietario getProprietario() {
        return proprietario;
    }

    /**
     * @param proprietario the proprietario to set
     */
    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }


}
