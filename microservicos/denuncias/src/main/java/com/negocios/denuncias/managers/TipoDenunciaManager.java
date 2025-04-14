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


    /**
     * Método para editar um tipo de Denuncia na base de dados
     * @param td Tipo Denuncia a editar.
     */
    public void editTipoDenuncia(TipoDenuncia td) throws SQLException {
        String query = "UPDATE tipo_denuncia SET descricao=?, " +
                "WHERE id=?";
        pst = conn.prepareStatement(query);
        pst.setString(1, td.getDescricao());
        pst.setInt(2, td.getId());
        pst.executeUpdate();
    }

    /**
     * Método para remover um Tipo Denuncia na base de dados
     * @param id Id do tipo de denuncia a remover.
     */
    public void deleteTipoDenuncia(int id) throws SQLException {
        String query = "DELETE FROM tipo_denuncia WHERE id=?";
        pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        pst.executeUpdate();
    }

    /**
     * Método para adicionar um tipo de denuncia na base de dados.
     *
     * @param td Tipo de denuncia a registar.
     */
    public void addTipoDenuncia(TipoDenuncia td) throws SQLException {
        String query = "INSERT INTO tipo_denuncia (descricao) VALUES (?)";
        pst = conn.prepareStatement(query);
        pst.setString(1, td.getDescricao());
        pst.executeUpdate();
    }


    /**
     * Método para buscar um Tipo de denuncia a base de dados
     * @param id Id do tipo de denuncia a ir buscar.
     */
    public TipoDenuncia getDenuncia(int id) throws SQLException {
        String query = "SELECT * FROM tipo_denuncia WHERE id=?";
        pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        rs = pst.executeQuery();
        if (rs.next()) {
            TipoDenuncia td = new TipoDenuncia();
            td.setId(rs.getInt("id"));
            td.setDescricao(rs.getString("descricao"));
            return td;
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