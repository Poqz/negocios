package com.negocios.denuncias.controllers;


import com.negocios.denuncias.managers.TipoDenunciaManager;
import com.negocios.denuncias.models.TipoDenuncia;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

public class TipoDenunciaController {
    private TipoDenunciaManager tipoDenunciaManager = new TipoDenunciaManager();

    @GetMapping("/tipoDenuncias/getAll")
    public ArrayList<TipoDenuncia> getAllTipoDenuncias() {
        return tipoDenunciaManager.getAllTipoDenuncias();
    }
}
