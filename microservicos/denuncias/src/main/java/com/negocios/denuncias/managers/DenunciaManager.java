package com.negocios.denuncias.managers;

import com.negocios.denuncias.database.DbMySQL;
import com.negocios.denuncias.models.Denuncia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DenunciaManager {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private ArrayList<Denuncia> denuncias = new ArrayList<Denuncia>();

    public DenunciaManager() {
        try {
            conn = new DbMySQL().getConn();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para registar uma Denuncia na base de dados.
     *
     * @param d Denuncia a registar.
     */
    public void addDenuncia(Denuncia d) {
        String query = "INSERT INTO denuncia (descricao, " +
                                            "denunciador_id, " +
                                            "denunciado_id, " +
                                            "tipo_denuncia_id) " +
                        "VALUES (?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, d.getDescricao());
            pst.setInt(2, d.getDenunciadorId());
            pst.setInt(3, d.getDenunciadoId());
            pst.setInt(4, d.getTipoDenunciaId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para editar uma Denuncia na base de dados
     * @param d Denuncia a editar.
     */
    public void editDenuncia(Denuncia d) {
        String query = "UPDATE denuncia SET descricao=?, " +
                                            "denunciador_id=?, " +
                                            "denunciado_id=?, " +
                                            "tipo_denuncia_id=? " +
                        "WHERE id=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, d.getDescricao());
            pst.setInt(2, d.getDenunciadorId());
            pst.setInt(3, d.getDenunciadoId());
            pst.setInt(4, d.getTipoDenunciaId());
            pst.setInt(5, d.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para remover uma Denuncia na base de dados
     * @param id Id da denuncia a remover.
     */
    public void deleteDenuncia(int id) {
        String query = "DELETE FROM denuncia WHERE id=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para buscar uma Denuncia a base de dados
     * @param id Id da denuncia a ir buscar.
     */
    public Denuncia getDenuncia(int id) {
        String query = "SELECT * FROM denuncia WHERE id=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                Denuncia d = new Denuncia();
                d.setId(rs.getInt("id"));
                d.setDescricao(rs.getString("descricao"));
                d.setDenunciadorId(rs.getInt("denunciador_id"));
                d.setDenunciadoId(rs.getInt("denunciado_id"));
                d.setData(rs.getDate("data"));
                d.setTipoDenunciaId(rs.getInt("tipo_denuncia_id"));
                return d;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Método para buscar todas as Denuncias na base de dados
     */
    public ArrayList<Denuncia> getAllDenuncias() {
        String query = "SELECT * FROM denuncia";

        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery(query);
            while (rs.next()) {
                Denuncia d = new Denuncia();
                d.setId(rs.getInt("id"));
                d.setDescricao(rs.getString("descricao"));
                d.setDenunciadorId(rs.getInt("denunciador_id"));
                d.setDenunciadoId(rs.getInt("denunciado_id"));
                d.setData(rs.getDate("data"));
                d.setTipoDenunciaId(rs.getInt("tipo_denuncia_id"));
                denuncias.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return denuncias;
    }
}