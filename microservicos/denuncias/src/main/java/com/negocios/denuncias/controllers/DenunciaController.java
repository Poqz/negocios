package com.negocios.denuncias.controllers;

import com.negocios.denuncias.models.Denuncia;
import com.negocios.denuncias.managers.DenunciaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class DenunciaController {

    private DenunciaManager denunciaManager = new DenunciaManager();

    @GetMapping("/denuncias/getAll")
    public ArrayList<Denuncia> getAll() throws SQLException {
        try {
            return denunciaManager.getAllDenuncias();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/denuncias/getDenuncia/{id}")
    public Denuncia getDenuncia(@PathVariable int id) {
        try {
        return denunciaManager.getDenuncia(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/denuncias/addDenuncia/{d}")
    public boolean addDenuncia(@PathVariable Denuncia d) {
        try {
            denunciaManager.addDenuncia(d);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/denuncias/editDenuncia")
    public boolean editDenuncia(@RequestBody Denuncia d) throws SQLException {
        try {
            denunciaManager.editDenuncia(d);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/denuncias/deleteDenuncia/{id}")
    public boolean deleteDenuncia(@PathVariable int id) {
        try {
            denunciaManager.deleteDenuncia(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}