package com.negocios.denuncias.managers;

import com.negocios.denuncias.models.TipoDenuncia;
import java.util.ArrayList;

public class TipoDenunciaManager {
    private ArrayList<TipoDenuncia> tipoDenuncias = new ArrayList<TipoDenuncia>();

    public void addTipoDenuncia(TipoDenuncia td) {
        tipoDenuncias.add(td);
    }

    public TipoDenuncia getTipoDenuncia(int id) {
        for (TipoDenuncia td : tipoDenuncias) {
            if (td.getId() == id) {
                return td;
            }
        }
        return null;
    }

    public ArrayList<TipoDenuncia> getAllTipoDenuncias() {
        return tipoDenuncias;
    }
}