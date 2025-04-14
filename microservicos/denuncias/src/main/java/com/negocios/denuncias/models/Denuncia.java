package com.negocios.denuncias.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Date;

public class Denuncia {
    @JsonProperty()
    private int id;
    private String descricao;
    private int denunciadorId;
    private int denunciadoId;
    private Date data;
    private int tipoDenunciaId;


    public Denuncia() {
    }

    public Denuncia(String descricao, int denunciadorId, int denunciadoId, int tipoDenunciaId) {
        this.descricao = descricao;
        this.denunciadorId = denunciadorId;
        this.denunciadoId = denunciadoId;
        // TODO: fix this? System.currentTimeMillis()
        this.data = new Date();
        this.tipoDenunciaId = tipoDenunciaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDenunciadorId() {
        return denunciadoId;
    }

    public void setDenunciadorId(int denunciadorId) {
        this.denunciadorId = denunciadorId;
    }

    public int getDenunciadoId() {
        return denunciadoId;
    }

    public void setDenunciadoId(int denunciadoId) {
        this.denunciadoId = denunciadoId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTipoDenunciaId() {
        return tipoDenunciaId;
    }
    public void setTipoDenunciaId(int tipoDenunciaId) {
        this.tipoDenunciaId = tipoDenunciaId;
    }
}
