package com.negocios.denuncias.controllers;

import com.negocios.denuncias.models.Denuncia;
import com.negocios.denuncias.managers.DenunciaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    private DenunciaManager denunciaManager = new DenunciaManager();

    @GetMapping("/getAll")
    public ArrayList<Denuncia> getAll() throws SQLException {
        try {
            return denunciaManager.getAllDenuncias();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getDenuncia/{id}")
    public Denuncia getDenuncia(@PathVariable (name="id") int id) {
        try {
        return denunciaManager.getDenuncia(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/addDenuncia/{d}")
    public boolean addDenuncia(@RequestBody Denuncia d) {
        try {
            denunciaManager.addDenuncia(d);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @PutMapping("/editDenuncia/{d}")
    public boolean editDenuncia(@RequestBody Denuncia d, @PathVariable(name = "id") int id) throws SQLException {
        try {
            denunciaManager.editDenuncia(d);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @DeleteMapping("/denuncias/deleteDenuncia/{id}")
    public boolean deleteDenuncia(@PathVariable (name = "id") int id) {
        try {
            denunciaManager.deleteDenuncia(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}