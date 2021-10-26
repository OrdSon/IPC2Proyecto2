/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Mirrors.SolicitudReporte;
import ReportObjects.GananciasEditorReport;
import ReportObjects.GananciasEditorSubReport;
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
public class ReporteGananciasEditorDAO extends DAO{
        String SELECCIONAR_REVISTAS = "SELECT r.codigo, r.precio, r.nombre , sum(p.monto) as suma FROM pago as p INNER JOIN suscripcion as s ON p.suscripcion_codigo = s.codigo\n" +
" INNER JOIN revista as r on s.revista_codigo = r.codigo WHERE r.autor = ? AND p.monto > 0 GROUP by codigo, precio, nombre ORDER BY suma DESC";
    
    String SELECCIONAR_UNA_REVISTA = "SELECT r.codigo, r.precio, r.nombre , sum(p.monto) as suma FROM pago as p INNER JOIN suscripcion as s ON p.suscripcion_codigo = s.codigo\n" +
" INNER JOIN revista as r on s.revista_codigo = r.codigo WHERE r.autor = ? AND r.codigo = ? AND p.monto > 0 GROUP by codigo, precio, nombre ORDER BY suma DESC";
    
    String SELECCIONAR_GANANCIAS_POR_REVISTA = " SELECT u.nombre, s.fecha, p.monto  FROM pago as p INNER JOIN suscripcion as s ON p.suscripcion_codigo = s.codigo\n" +
" INNER JOIN revista as r on s.revista_codigo = r.codigo INNER JOIN usuario AS u ON u.codigo = s.usuario_codigo WHERE r.codigo = ? AND p.monto > 0 AND s.fecha BETWEEN ? AND ?";
    double cantidad = 0;

    //PRIMERA CONDICION: Estado, tiene que ser "activo"
    //SEGUNDA CONDICION: CODIGO de la revista, es un int;
    //TERCERA CONDICION: dos Fechas, una inicial y otra final
    public List<GananciasEditorReport> ReporteGanancias(SolicitudReporte solicitud) {

        ArrayList<GananciasEditorReport> registros = new ArrayList<>();

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
                GananciasEditorReport created = getGananciasEditorReport(resultSet, solicitud);

                if (created != null) {
                    registros.add(created);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    public List<GananciasEditorSubReport> subListaSuscripciones(int codigo, SolicitudReporte solicitud) {


        ArrayList<GananciasEditorSubReport> registros = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_GANANCIAS_POR_REVISTA);
            preparedStatement.setInt(1, codigo);
            preparedStatement.setDate(2, Date.valueOf(solicitud.getFechaInicial()));
            preparedStatement.setDate(3, Date.valueOf(solicitud.getFechaFinal()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String usuario = resultSet.getString("nombre");
                String fecha = resultSet.getDate("fecha").toString();
                double subTotal = resultSet.getDouble("monto");
                String monto = String.format("%.2f", subTotal);
                registros.add(new GananciasEditorSubReport(usuario, fecha, monto));
                cantidad+=subTotal;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    private GananciasEditorReport getGananciasEditorReport(ResultSet resultSet, SolicitudReporte solicitud) throws SQLException {
        int codigo = resultSet.getInt("codigo");
        String nombre = resultSet.getString("nombre");
        double precio = resultSet.getDouble("precio");
        double suma = resultSet.getDouble("suma");
        String monto = String.format("%.2f", suma);

            
        List<GananciasEditorSubReport> lista = subListaSuscripciones(codigo, solicitud);

        GananciasEditorReport suscriptionReport = new GananciasEditorReport(monto, codigo+"", nombre, precio+"", lista);
        return suscriptionReport;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
