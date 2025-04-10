package com.negocios.denuncias.models;

import java.util.Date;

public class Denuncia {
    private int id;
    private String descricao;
    private int denunciador_ID;
    private int denunciado_ID;
    private Date data;
    private int tipoDenunciaId;

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

    public int getDenunciador_ID() {
        return denunciador_ID;
    }

    public void setDenunciador_ID(int denunciador_ID) {
        this.denunciador_ID = denunciador_ID;
    }

    public int getDenunciado_ID() {
        return denunciado_ID;
    }

    public void setDenunciado_ID(int denunciado_ID) {
        this.denunciado_ID = denunciado_ID;
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



