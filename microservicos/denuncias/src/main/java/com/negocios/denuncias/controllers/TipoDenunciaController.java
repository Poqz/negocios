package com.negocios.denuncias.controllers;


import com.negocios.denuncias.managers.TipoDenunciaManager;
import com.negocios.denuncias.models.TipoDenuncia;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class TipoDenunciaController {
    private TipoDenunciaManager tipoDenunciaManager = new TipoDenunciaManager();

    @GetMapping("/tipoDenuncias/getAll")
    public ArrayList<TipoDenuncia> getAllTipoDenuncias() {
        try {
            return tipoDenunciaManager.getAllTipoDenuncias();
        } catch ( SQLException e ) {
            e.printStackTrace();
            return null;
        }
    }
}
