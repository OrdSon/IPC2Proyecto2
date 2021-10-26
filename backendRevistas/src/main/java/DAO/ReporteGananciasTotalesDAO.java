/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Mirrors.SolicitudReporte;
import ReportObjects.GananciasTotalesReport;
import ReportObjects.GananciasTotalesSubReport;
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
public class ReporteGananciasTotalesDAO extends DAO{

    String SELECT_DIAS = "select fecha, sum(monto) as suma from cobro WHERE fecha BETWEEN ? AND ? group by fecha  ORDER BY fecha DESC";
    
    String SELECT_COBROS_POR_DIA = " select  c.anuncio_codigo, c.pago_codigo , c.monto ,c.fecha from cobro  AS c  left join anuncio as a on c.anuncio_codigo = a.codigo left join pago as p on p.codigo = c.pago_codigo WHERE c.fecha = ?";
    double total = 0;
    //PRIMERA CONDICION: Estado, tiene que ser "activo"
    //SEGUNDA CONDICION: CODIGO de la revista, es un int;
    //TERCERA CONDICION: dos Fechas, una inicial y otra final
    public List<GananciasTotalesReport> ReporteGanancias(SolicitudReporte solicitud) {
        
        ArrayList<GananciasTotalesReport> registros = new ArrayList<>();
        if (solicitud.getFechaInicial() == null) {
            solicitud.setFechaInicial("2000-01-01");
        }
        if (solicitud.getFechaFinal() == null) {
            solicitud.setFechaFinal("2100-01-01");
        }

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DIAS);
            preparedStatement.setDate(1, Date.valueOf(solicitud.getFechaInicial()));
            preparedStatement.setDate(2, Date.valueOf(solicitud.getFechaFinal()));

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GananciasTotalesReport created = getGananciasTotalesReport(resultSet, solicitud);

                if (created != null) {
                    registros.add(created);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    public List<GananciasTotalesSubReport> subListaSuscripciones(Date fecha , SolicitudReporte solicitud) {


        ArrayList<GananciasTotalesSubReport> registros = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COBROS_POR_DIA);
            preparedStatement.setDate(1, fecha);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String date = resultSet.getDate("fecha").toString();
                double subTotal = resultSet.getDouble("monto");
                String monto = String.format("%.2f", subTotal);
                int anuncio = resultSet.getInt("anuncio_codigo");
                int pago = resultSet.getInt("pago_codigo");
                String tipo = "";
                if (anuncio > 0) {
                    tipo = "Anuncio";
                }else if(pago>0){
                    tipo = "Pago";
                }
                total += subTotal;
                registros.add(new GananciasTotalesSubReport(tipo, monto, date));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    private GananciasTotalesReport getGananciasTotalesReport(ResultSet resultSet, SolicitudReporte solicitud) throws SQLException {
        Date fecha = resultSet.getDate("fecha");
        double subTotal = resultSet.getDouble("suma");
        String monto = String.format("%.2f", subTotal);
            
        List<GananciasTotalesSubReport> lista = subListaSuscripciones(fecha, solicitud);

        GananciasTotalesReport suscriptionReport = new GananciasTotalesReport(fecha.toString(), monto, lista);
        return suscriptionReport;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
