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
        Denuncia d = new Denuncia("Portou-se mal", 1, 2,  2);
        denunciaManager.addDenuncia(d);

        return denunciaManager.getAllDenuncias();
    }


    @PostMapping
    public boolean addDenuncia(@RequestBody Denuncia d) {
        denunciaManager.addDenuncia(d);
        return true;
    }


}
