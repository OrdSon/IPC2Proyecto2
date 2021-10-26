/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Mirrors.SolicitudSuscripciones;
import ReportObjects.SuscriptionReport;
import ReportObjects.SuscriptionSubReport;
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
public class ReporteSuscripcionesDAO extends DAO {

    String SELECCIONAR_REVISTAS = "SELECT * FROM revista WHERE autor = ?";
    String SELECCIONAR_UNA_REVISTA = "SELECT * FROM revista WHERE autor = ? AND codigo = ?";
    String SELECCIONAR_SUSCRIPCIONES_POR_REVISTA = "SELECT r.precio, u.nombre, s.fecha FROM revista as r\n"
            + " INNER JOIN suscripcion as s ON r.codigo = s.revista_codigo INNER JOIN usuario as u ON s.usuario_codigo\n"
            + " = u.codigo WHERE s.estado = ? AND r.codigo = ? AND s.fecha BETWEEN ? AND ?;";

    //PRIMERA CONDICION: Estado, tiene que ser "activo"
    //SEGUNDA CONDICION: CODIGO de la revista, es un int;
    //TERCERA CONDICION: dos Fechas, una inicial y otra final
    public List<SuscriptionReport> ReporteSuscripciones(SolicitudSuscripciones solicitud) {

        ArrayList<SuscriptionReport> registros = new ArrayList<>();

        try {
            String query = SELECCIONAR_REVISTAS;
            if (solicitud.getRevista() > 0) {
                query = SELECCIONAR_UNA_REVISTA;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, solicitud.getAutor());
            if (solicitud.getRevista() > 0) {
                preparedStatement.setInt(2, solicitud.getRevista());
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SuscriptionReport created = getSuscriptionReport(resultSet, solicitud);

                if (created != null) {
                    registros.add(created);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    public List<SuscriptionSubReport> subListaSuscripciones(int codigo, SolicitudSuscripciones solicitud) {
        
        if (solicitud.getFechaInicial() == null) {
            solicitud.setFechaInicial("2000-01-01");
        }
        if (solicitud.getFechaFinal() == null) {
            solicitud.setFechaFinal("2100-01-01");
        }

        ArrayList<SuscriptionSubReport> registros = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_SUSCRIPCIONES_POR_REVISTA);
            preparedStatement.setString(1, "true");
            preparedStatement.setInt(2, codigo);
            preparedStatement.setDate(3, Date.valueOf(solicitud.getFechaInicial()));
            preparedStatement.setDate(4, Date.valueOf(solicitud.getFechaFinal()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double precio = resultSet.getDouble("precio");
                String usuario = resultSet.getString("nombre");
                String fecha = resultSet.getDate("fecha").toString();
                
                registros.add(new SuscriptionSubReport(usuario, fecha, precio+""));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    private SuscriptionReport getSuscriptionReport(ResultSet resultSet, SolicitudSuscripciones solicitud) throws SQLException {
        int codigo = resultSet.getInt("codigo");
        String nombre = resultSet.getString("nombre");
        List<SuscriptionSubReport> lista = subListaSuscripciones(codigo, solicitud);

        SuscriptionReport suscriptionReport = new SuscriptionReport(codigo + "", nombre, lista);
        return suscriptionReport;
    }
}
