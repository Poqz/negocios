package com.negocios.denuncias.managers;

import com.negocios.denuncias.models.Denuncia;
import java.util.ArrayList;

public class DenunciaManager {

    private ArrayList<Denuncia> denuncias = new ArrayList<Denuncia>();

    public void addDenuncia(Denuncia d) {
        denuncias.add(d);
    }

    public Denuncia getDenuncia(int id) {
        for (Denuncia d : denuncias) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public ArrayList<Denuncia> getAllDenuncias() {
        return denuncias;
    }
}
