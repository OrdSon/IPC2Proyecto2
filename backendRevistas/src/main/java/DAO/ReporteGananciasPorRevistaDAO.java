/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Mirrors.SolicitudReporte;
import ReportObjects.GananciasAdminSubReport;
import ReportObjects.GananciasRevistaAdminReport;
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
public class ReporteGananciasPorRevistaDAO extends DAO {

    String SELECCIONAR_REVISTAS = "SELECT r.codigo, r.nombre, r.precio, sum(c.monto) AS cobro, sum(p.monto) AS suma, count(c.codigo) as cuenta FROM cobro AS c \n"
            + "INNER JOIN pago as p ON c.pago_codigo = p.codigo \n"
            + "INNER JOIN suscripcion AS s ON p.suscripcion_codigo = s.codigo\n"
            + "INNER JOIN revista AS r ON s.revista_codigo = r.codigo  \n"
            + "GROUP BY r.codigo ORDER BY cobro DESC";

    String SELECCIONAR_UNA_REVISTA = "SELECT r.codigo, r.nombre, r.precio, sum(c.monto) AS cobro, sum(p.monto) AS suma, count(c.codigo) as cuenta FROM cobro AS c \n"
            + "INNER JOIN pago as p ON c.pago_codigo = p.codigo \n"
            + "INNER JOIN suscripcion AS s ON p.suscripcion_codigo = s.codigo\n"
            + "INNER JOIN revista AS r ON s.revista_codigo = r.codigo WHERE r.codigo = ? \n"
            + "GROUP BY r.codigo ORDER BY cobro DESC";

    String SELECCIONAR_GANANCIAS_POR_REVISTA = "SELECT s.fecha, u.nombre, r.precio, c.monto FROM cobro AS c \n"
            + "INNER JOIN pago AS p ON c.pago_codigo = p.codigo \n"
            + "INNER JOIN suscripcion AS s ON p.suscripcion_codigo = s.codigo \n"
            + "INNER JOIN revista AS r ON s.revista_codigo = r.codigo \n"
            + "INNER JOIN usuario AS u ON s.usuario_codigo = u.codigo WHERE r.codigo = ? AND s.fecha BETWEEN ? AND ?";

    private double ganancia = 0;
    private double ingreso = 0;
    //PRIMERA CONDICION: Estado, tiene que ser "activo"
    //SEGUNDA CONDICION: CODIGO de la revista, es un int;
    //TERCERA CONDICION: dos Fechas, una inicial y otra final
    public List<GananciasRevistaAdminReport> ReporteGanancias(SolicitudReporte solicitud) {

        ArrayList<GananciasRevistaAdminReport> registros = new ArrayList<>();

        try {
            String query = SELECCIONAR_REVISTAS;
            if (solicitud.getRevista() > 0) {
                query = SELECCIONAR_UNA_REVISTA;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (solicitud.getRevista() > 0) {
                preparedStatement.setInt(1, solicitud.getRevista());
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GananciasRevistaAdminReport created = getGananciasEditorReport(resultSet, solicitud);

                if (created != null) {
                    registros.add(created);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    public List<GananciasAdminSubReport> subListaSuscripciones(int codigo, SolicitudReporte solicitud) {

        ArrayList<GananciasAdminSubReport> registros = new ArrayList<>();
         if (solicitud.getFechaInicial() == null) {
            solicitud.setFechaInicial("2000-01-01");
        }
        if (solicitud.getFechaFinal() == null) {
            solicitud.setFechaFinal("2100-01-01");
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_GANANCIAS_POR_REVISTA);
            preparedStatement.setInt(1, codigo);
            preparedStatement.setDate(2, Date.valueOf(solicitud.getFechaInicial()));
            preparedStatement.setDate(3, Date.valueOf(solicitud.getFechaFinal()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String usuario = resultSet.getString("nombre");
                String fecha = resultSet.getDate("fecha").toString();
                double price = resultSet.getDouble("precio");
                double subTotal = resultSet.getDouble("monto");
                String monto = String.format("%.2f", subTotal);
                String precio = String.format("%.2f", price);
                ingreso += price;
                ganancia += subTotal;
                registros.add(new GananciasAdminSubReport(usuario, fecha, precio, monto));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    private GananciasRevistaAdminReport getGananciasEditorReport(ResultSet resultSet, SolicitudReporte solicitud) throws SQLException {
        int codigo = resultSet.getInt("codigo");
        String nombre = resultSet.getString("nombre");
        String costo = resultSet.getDouble("precio") + "";
        double cobro = resultSet.getDouble("cobro");
        double suma = resultSet.getDouble("suma");
        String earngings = String.format("%.2f", cobro);
        String in = String.format("%.2f", suma);
        List<GananciasAdminSubReport> lista = subListaSuscripciones(codigo, solicitud);

        GananciasRevistaAdminReport suscriptionReport = new GananciasRevistaAdminReport(codigo+"", nombre, costo, earngings, in, lista);
        return suscriptionReport;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

}
