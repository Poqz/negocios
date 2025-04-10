package com.negocios.denuncias.models;

import java.time.LocalDateTime;
import java.util.Date;

public class Denuncia {
    private int id;
    private String descricao;
    private int denunciadorId;
    private int denunciadoId;
    private LocalDateTime data;
    private int tipoDenunciaId;

    public Denuncia(String descricao, int denunciadorId, int denunciadoId, int tipoDenunciaId) {
        this.descricao = descricao;
        this.denunciadorId = denunciadorId;
        this.denunciadoId = denunciadoId;
        this.data = LocalDateTime.now();
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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getTipoDenunciaId() {
        return tipoDenunciaId;
    }
    public void setTipoDenunciaId(int tipoDenunciaId) {
        this.tipoDenunciaId = tipoDenunciaId;
    }
}
