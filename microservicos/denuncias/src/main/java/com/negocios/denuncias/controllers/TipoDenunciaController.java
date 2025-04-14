package com.negocios.denuncias.controllers;


import com.negocios.denuncias.managers.TipoDenunciaManager;
import com.negocios.denuncias.models.Denuncia;
import com.negocios.denuncias.models.TipoDenuncia;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/tipoDenuncias")
public class TipoDenunciaController {
    private TipoDenunciaManager tipoDenunciaManager = new TipoDenunciaManager();

    @GetMapping("/getAll")
    public ArrayList<TipoDenuncia> getAllTipoDenuncias() {
        try {
            return tipoDenunciaManager.getAllTipoDenuncias();
        } catch ( SQLException e ) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getTipoDenuncia/{id}")
    public TipoDenuncia getTipoDenuncia(@PathVariable int id) {
        try {
            return tipoDenunciaManager.getDenuncia(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/editTipoDenuncia/{td}")
    public boolean editTipoDenuncia(@RequestBody TipoDenuncia td) {
        try {
            tipoDenunciaManager.editTipoDenuncia(td);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/addTipoDenuncia")
    public boolean addTipoDenuncia(@RequestBody TipoDenuncia td) {
        try {
            tipoDenunciaManager.addTipoDenuncia(td);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @DeleteMapping("/deleteTipoDenuncia/{id}")
    public boolean DeleteTipoDenuncia(@PathVariable int id) {
        try {
            tipoDenunciaManager.deleteTipoDenuncia(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}