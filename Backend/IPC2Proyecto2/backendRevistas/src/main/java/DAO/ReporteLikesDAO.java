/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Mirrors.SolicitudReporte;
import ReportObjects.LikesReport;
import ReportObjects.LikesSubReport;
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
public class ReporteLikesDAO extends DAO {

    String SELECCIONAR_REVISTAS = "SELECT count(review.numero_codigo) as cuenta,  review.numero_codigo , revista.nombre, revista.codigo FROM review \n"
            + "INNER JOIN numero ON review.numero_codigo = numero.codigo \n"
            + "INNER JOIN revista ON revista.codigo = numero.revista_codigo WHERE review.likes = 1 AND revista.autor = ? \n"
            + "GROUP BY review.numero_codigo ORDER BY cuenta DESC;";
    
    String SELECCIONAR_UNA_REVISTA = "SELECT count(review.numero_codigo) as cuenta,  review.numero_codigo , revista.nombre, revista.codigo FROM review \n"
            + "INNER JOIN numero ON review.numero_codigo = numero.codigo \n"
            + "INNER JOIN revista ON revista.codigo = numero.revista_codigo WHERE review.likes = 1 AND revista.autor = ? AND revista.codigo = ? \n"
            + "GROUP BY review.numero_codigo ORDER BY cuenta DESC;";
    
    String SELECCIONAR_LIKES_POR_REVISTA = "SELECT u.nombre, r.fecha FROM review AS r INNER JOIN usuario AS u ON r.codigo = u.codigo \n"
            + "INNER JOIN numero AS n ON r.numero_codigo = n.codigo INNER JOIN revista \n"
            + "AS j ON n.revista_codigo = j.codigo WHERE r.likes = 1 AND j.codigo = ? AND r.fecha BETWEEN ? AND ?";
    int cantidad = 0;

    //PRIMERA CONDICION: Estado, tiene que ser "activo"
    //SEGUNDA CONDICION: CODIGO de la revista, es un int;
    //TERCERA CONDICION: dos Fechas, una inicial y otra final
    public List<LikesReport> ReporteLikes(SolicitudReporte solicitud) {

        ArrayList<LikesReport> registros = new ArrayList<>();

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
                LikesReport created = getLikesReport(resultSet, solicitud);

                if (created != null) {
                    registros.add(created);
                    cantidad = 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    public List<LikesSubReport> subListaSuscripciones(int codigo, SolicitudReporte solicitud) {

        if (solicitud.getFechaInicial() == null) {
            solicitud.setFechaInicial("2000-01-01");
        }
        if (solicitud.getFechaFinal() == null) {
            solicitud.setFechaFinal("2100-01-01");
        }

        ArrayList<LikesSubReport> registros = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_LIKES_POR_REVISTA);
            preparedStatement.setInt(1, codigo);
            preparedStatement.setDate(2, Date.valueOf(solicitud.getFechaInicial()));
            preparedStatement.setDate(3, Date.valueOf(solicitud.getFechaFinal()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String usuario = resultSet.getString("nombre");
                String fecha = resultSet.getDate("fecha").toString();
                registros.add(new LikesSubReport(usuario, fecha));
                cantidad++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    private LikesReport getLikesReport(ResultSet resultSet, SolicitudReporte solicitud) throws SQLException {
        int codigo = resultSet.getInt("codigo");
        String nombre = resultSet.getString("nombre");
        List<LikesSubReport> lista = subListaSuscripciones(codigo, solicitud);

        LikesReport suscriptionReport = new LikesReport(codigo + "", nombre, cantidad + "", lista);
        return suscriptionReport;
    }

}
