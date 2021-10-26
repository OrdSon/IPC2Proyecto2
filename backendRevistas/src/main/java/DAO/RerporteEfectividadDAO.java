/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Mirrors.SolicitudReporte;
import ReportObjects.EfectividadReport;
import ReportObjects.EfectividadSubReport;
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
public class RerporteEfectividadDAO extends DAO{
    
        String SELECT_ANUNCIANTES = "SELECT * FROM anunciante";
        String SELECT_UN_ANUNCIANTE = "SELECT * FROM anunciante WHERE codigo = ?";
    
    String SELECT_ANUNCIOS = "SELECT a.codigo ,a.nombre, o.nombre as anuncio, o.veces, o.fecha FROM anunciante as a "
            + "INNER JOIN anuncio as o ON a.codigo = o.anunciante_codigo WHERE veces > 0 AND a.codigo = ? AND o.fecha BETWEEN ? AND ? ORDER BY veces DESC;";
    double total = 0;
    //PRIMERA CONDICION: Estado, tiene que ser "activo"
    //SEGUNDA CONDICION: CODIGO de la revista, es un int;
    //TERCERA CONDICION: dos Fechas, una inicial y otra final
    public List<EfectividadReport> ReporteGanancias(SolicitudReporte solicitud) {
        
        ArrayList<EfectividadReport> registros = new ArrayList<>();
        
        String query = SELECT_ANUNCIANTES;
        if (solicitud.getRevista() > 0) {
            query = SELECT_UN_ANUNCIANTE;
        }
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (solicitud.getRevista() > 0) {
                preparedStatement.setInt(1, solicitud.getRevista());
            }


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EfectividadReport created = getEfectividadReport(resultSet, solicitud);

                if (created != null) {
                    registros.add(created);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    public List<EfectividadSubReport> subListaSuscripciones(int codigo , SolicitudReporte solicitud) {

        if (solicitud.getFechaInicial() == null) {
            solicitud.setFechaInicial("2000-01-01");
        }
        if (solicitud.getFechaFinal() == null) {
            solicitud.setFechaFinal("2100-01-01");
        }
        ArrayList<EfectividadSubReport> registros = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ANUNCIOS);
            preparedStatement.setInt(1, codigo);
            preparedStatement.setDate(2, Date.valueOf(solicitud.getFechaInicial()));
            preparedStatement.setDate(3, Date.valueOf(solicitud.getFechaFinal()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String anuncio = resultSet.getString("anuncio");
                String veces = resultSet.getInt("veces")+"";
                String fecha = resultSet.getDate("fecha").toString();
                registros.add(new EfectividadSubReport(anuncio, veces, fecha));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    private EfectividadReport getEfectividadReport(ResultSet resultSet, SolicitudReporte solicitud) throws SQLException {
        String nombre = resultSet.getString("nombre");
        int codigo = resultSet.getInt("codigo");
            
        List<EfectividadSubReport> lista = subListaSuscripciones(codigo, solicitud);

        EfectividadReport suscriptionReport = new EfectividadReport(nombre, lista);
        return suscriptionReport;
    }

}
