/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Mirrors.SolicitudReporte;
import ReportObjects.GananciasAnuncianteReport;
import ReportObjects.GananciasAnuncianteSubReport;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ordson
 */
public class ReporteFinalDAO extends DAO {

    String SELECT_ANUNCIANTES = "SELECT * FROM anunciante";
    String SELECT_UN_ANUNCIANTE = "SELECT * FROM anunciante WHERE codigo = ?";

    String SELECT_ANUNCIOS = "SELECT anunciante.codigo,anuncio.codigo as anuncio, anuncio.nombre, cobro.fecha, cobro.monto, anuncio.cantidad_horas FROM anunciante \n"
            + "INNER JOIN anuncio on anunciante.codigo = anuncio.anunciante_codigo\n"
            + "INNER JOIN cobro ON anuncio.codigo = cobro.anuncio_codigo WHERE anunciante.codigo = ? AND cobro.fecha BETWEEN ? AND ?";
    double total = 0;

    //PRIMERA CONDICION: Estado, tiene que ser "activo"
    //SEGUNDA CONDICION: CODIGO de la revista, es un int;
    //TERCERA CONDICION: dos Fechas, una inicial y otra final
    public List<GananciasAnuncianteReport> ReporteGanancias(SolicitudReporte solicitud) {

        ArrayList<GananciasAnuncianteReport> registros = new ArrayList<>();

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
                GananciasAnuncianteReport created = getGananciasAnuncianteReport(resultSet, solicitud);

                if (created != null) {
                    registros.add(created);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    public List<GananciasAnuncianteSubReport> subListaSuscripciones(int codigo, SolicitudReporte solicitud) {

        if (solicitud.getFechaInicial() == null) {
            solicitud.setFechaInicial("2000-01-01");
        }
        if (solicitud.getFechaFinal() == null) {
            solicitud.setFechaFinal("2100-01-01");
        }
        ArrayList<GananciasAnuncianteSubReport> registros = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ANUNCIOS);
            preparedStatement.setInt(1, codigo);
            preparedStatement.setDate(2, Date.valueOf(solicitud.getFechaInicial()));
            preparedStatement.setDate(3, Date.valueOf(solicitud.getFechaFinal()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String anuncio = resultSet.getInt("anuncio") + "";
                String nombre = resultSet.getString("nombre");
                String horas = resultSet.getInt("cantidad_horas") + "";
                double result = resultSet.getDouble("monto");
                total += result;
                DecimalFormat numberFormat = new DecimalFormat("#.00");
                String monto = numberFormat.format(result);
                String fecha = resultSet.getDate("fecha").toString();
                registros.add(new GananciasAnuncianteSubReport(anuncio, nombre, fecha, horas, monto));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    private GananciasAnuncianteReport getGananciasAnuncianteReport(ResultSet resultSet, SolicitudReporte solicitud) throws SQLException {
        String nombre = resultSet.getString("nombre");
        int codigo = resultSet.getInt("codigo");

        List<GananciasAnuncianteSubReport> lista = subListaSuscripciones(codigo, solicitud);

        GananciasAnuncianteReport suscriptionReport = new GananciasAnuncianteReport(nombre, lista);
        return suscriptionReport;
    }
    
    public double getTotal(){
        return  this.total;
    }
}
