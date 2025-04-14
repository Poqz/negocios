package com.negocios.denuncias.controllers;


import com.negocios.denuncias.managers.TipoDenunciaManager;
import com.negocios.denuncias.models.Denuncia;
import com.negocios.denuncias.models.TipoDenuncia;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/tipoDenuncias/getTipoDenuncia/{id}")
    public TipoDenuncia getTipoDenuncia(@PathVariable int id) {
        try {
            return tipoDenunciaManager.getDenuncia(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/tipoDenuncias/editTipoDenuncia/{td}")
    public boolean editTipoDenuncia(@RequestBody TipoDenuncia td) {
        try {
            tipoDenunciaManager.editTipoDenuncia(td);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/tipoDenuncias/addTipoDenuncia/{td}")
    public boolean addTipoDenuncia(@PathVariable TipoDenuncia td) {
        try {
            tipoDenunciaManager.addTipoDenuncia(td);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @PostMapping("/tipoDenuncias/deleteTipoDenuncia/{id}")
    public boolean addTipoDenuncia(@PathVariable int id) {
        try {
            tipoDenunciaManager.deleteTipoDenuncia(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
