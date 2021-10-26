/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Mirrors.SolicitudReporte;
import ReportObjects.AnunciosReport;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ordson
 */
public class ReporteAnunciosDAO extends DAO {

    String SELECT_COMENTARIOS = "SELECT a.codigo, a.nombre as anuncio, a.veces, a.fecha, a.cantidad_horas as dias, e.nombre as anunciante FROM\n"
            + " anuncio AS a INNER JOIN anunciante AS e ON a.anunciante_codigo = e.codigo WHERE a.veces > 0 AND a.fecha BETWEEN ? AND ? ORDER BY a.veces DESC";

    public List<AnunciosReport> ReporteAnuncios(SolicitudReporte solicitud) {
        ArrayList<AnunciosReport> registros = new ArrayList<>();
        if (solicitud.getFechaInicial() == null) {
            solicitud.setFechaInicial("2000-01-01");
        }
        if (solicitud.getFechaFinal() == null) {
            solicitud.setFechaFinal("2100-01-01");
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMENTARIOS);

            preparedStatement.setDate(1, Date.valueOf(solicitud.getFechaInicial()));
            preparedStatement.setDate(2, Date.valueOf(solicitud.getFechaFinal()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                AnunciosReport AnunciosReport = getAnunciosReport(resultSet);
                if (AnunciosReport != null) {
                    registros.add(AnunciosReport);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }



    public AnunciosReport getAnunciosReport(ResultSet resultSet) throws SQLException {
        String codigo = resultSet.getInt("codigo")+"";
        String anuncio = resultSet.getString("anuncio");
        String veces = resultSet.getInt("veces")+"";
        String fecha = resultSet.getDate("fecha").toString();
        String dias = resultSet.getInt("dias")+"";
        String anunciante = resultSet.getString("anunciante");

        return new AnunciosReport(codigo, anuncio, veces, fecha, dias, anunciante);
    }

}
