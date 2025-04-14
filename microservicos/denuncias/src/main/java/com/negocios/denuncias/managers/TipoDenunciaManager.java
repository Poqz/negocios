package com.negocios.denuncias.managers;

import com.negocios.denuncias.database.DbMySQL;
import com.negocios.denuncias.models.Denuncia;
import com.negocios.denuncias.models.TipoDenuncia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoDenunciaManager {

    private ArrayList<TipoDenuncia> tipoDenuncias = new ArrayList<TipoDenuncia>();

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public TipoDenunciaManager() {
        try {
            conn = new DbMySQL().getConn();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

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

    /**
     * Método para buscar todas os tipos de denuncias na base de dados
     */
    public ArrayList<TipoDenuncia> getAllTipoDenuncias() throws SQLException {
        String query = "SELECT * FROM tipo_denuncia";

        tipoDenuncias.clear();
        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();
        while (rs.next()) {
            TipoDenuncia td = new TipoDenuncia();
            td.setId(rs.getInt("id"));
            td.setDescricao(rs.getString("descricao"));
            tipoDenuncias.add(td);
        }
        return tipoDenuncias;
    }
}