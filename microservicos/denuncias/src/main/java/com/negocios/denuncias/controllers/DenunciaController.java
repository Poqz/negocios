package com.negocios.denuncias.controllers;

import com.negocios.denuncias.models.Denuncia;
import com.negocios.denuncias.managers.DenunciaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DenunciaController {

    private DenunciaManager denunciaManager = new DenunciaManager();

    @GetMapping("/denuncias/getAll")
    public ArrayList<Denuncia> getAll() {
        return denunciaManager.getAllDenuncias();
    }

    @GetMapping("/denuncias/getDenuncia")
    public Denuncia getDenuncia(@RequestBody int id) {
        return denunciaManager.getDenuncia(id);
    }

    @PostMapping("/denuncias/addDenuncia")
    public boolean addDenuncia(@RequestBody Denuncia d) {
        denunciaManager.addDenuncia(d);
        return true;
    }

    @PostMapping("/denuncias/editDenuncia")
    public boolean editDenuncia(@RequestBody Denuncia d) {
        denunciaManager.editDenuncia(d);
        return true;
    }

    @PostMapping("/denuncias/deleteDenuncia")
    public boolean deleteDenuncia(@RequestBody int id) {
        denunciaManager.deleteDenuncia(id);
        return true;
    }
}