package com.negocios.denuncias.controllers;

import com.negocios.denuncias.models.Denuncia;
import com.negocios.denuncias.managers.DenunciaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DenunciaController {

    private DenunciaManager denunciaManager = new DenunciaManager();

    @GetMapping("/denuncias/getAll")
    public ArrayList<Denuncia> getAll() {
        return denunciaManager.getAllDenuncias();
    }

    @GetMapping("/denuncias/getDenuncia/{id}")
    public Denuncia getDenuncia(@PathVariable int id) {
        return denunciaManager.getDenuncia(id);
    }

    @PostMapping("/denuncias/addDenuncia/{d}")
    public boolean addDenuncia(@PathVariable Denuncia d) {
        denunciaManager.addDenuncia(d);
        return true;
    }

    @PostMapping("/denuncias/editDenuncia")
    public boolean editDenuncia(@PathVariable Denuncia d) {
        denunciaManager.editDenuncia(d);
        return true;
    }

    @PostMapping("/denuncias/deleteDenuncia/{id}")
    public boolean deleteDenuncia(@PathVariable int id) {
        denunciaManager.deleteDenuncia(id);
        return true;
    }
}