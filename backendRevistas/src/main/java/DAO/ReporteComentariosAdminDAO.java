/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Mirrors.SolicitudReporte;
import ReportObjects.CommentAdminReport;
import ReportObjects.CommentAdminSubReport;
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
public class ReporteComentariosAdminDAO extends DAO {

    String SELECCIONAR_REVISTAS = "SELECT count(revista.codigo) as cuenta , revista.nombre, revista.codigo, revista.nombre FROM review \n"
            + "INNER JOIN numero ON review.numero_codigo = numero.codigo \n"
            + "INNER JOIN revista ON revista.codigo = numero.revista_codigo GROUP BY revista.codigo ORDER BY cuenta DESC LIMIT 5";

    String SELECCIONAR_UNA_REVISTA = "SELECT count(revista.codigo) as cuenta , revista.nombre, revista.codigo , revista.nombre FROM review \n"
            + "INNER JOIN numero ON review.numero_codigo = numero.codigo \n"
            + "INNER JOIN revista ON revista.codigo = numero.revista_codigo WHERE revista.codigo = ? GROUP BY revista.codigo ORDER BY cuenta DESC LIMIT 5";

    String SELECCIONAR_LIKES_POR_REVISTA = "SELECT r.numero_codigo, n.nombre as numero , u.nombre, r.fecha , r.comentario FROM review AS r INNER JOIN usuario AS u ON r.codigo = u.codigo \n"
            + "INNER JOIN numero AS n ON r.numero_codigo = n.codigo INNER JOIN revista \n"
            + "AS j ON n.revista_codigo = j.codigo WHERE j.codigo = ? AND r.fecha BETWEEN ? AND ? group by numero_codigo, numero, nombre, fecha, comentario";

    //PRIMERA CONDICION: Estado, tiene que ser "activo"
    //SEGUNDA CONDICION: CODIGO de la revista, es un int;
    //TERCERA CONDICION: dos Fechas, una inicial y otra final
    public List<CommentAdminReport> ReporteComentarios(SolicitudReporte solicitud) {

        ArrayList<CommentAdminReport> registros = new ArrayList<>();

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
                CommentAdminReport created = getCommentAdminReport(resultSet, solicitud);

                if (created != null) {
                    registros.add(created);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    public List<CommentAdminSubReport> subListaSuscripciones(int codigo, SolicitudReporte solicitud) {

        if (solicitud.getFechaInicial() == null) {
            solicitud.setFechaInicial("2000-01-01");
        }
        if (solicitud.getFechaFinal() == null) {
            solicitud.setFechaFinal("2100-01-01");
        }

        ArrayList<CommentAdminSubReport> registros = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_LIKES_POR_REVISTA);
            if (solicitud.getFechaInicial() == null) {
                solicitud.setFechaInicial("2000-01-01");
            }
            if (solicitud.getFechaFinal() == null) {
                solicitud.setFechaFinal("2100-01-01");
            }
            preparedStatement.setInt(1, codigo);
            preparedStatement.setDate(2, Date.valueOf(solicitud.getFechaInicial()));
            preparedStatement.setDate(3, Date.valueOf(solicitud.getFechaFinal()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String numero = resultSet.getString("numero");
                String usuario = resultSet.getString("nombre");
                String comentario = resultSet.getString("comentario");
                String fecha = resultSet.getDate("fecha").toString();
                String numeroCodigo = resultSet.getInt("numero_codigo") + "";

                registros.add(new CommentAdminSubReport(numeroCodigo, numero, usuario, fecha, comentario));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }

    private CommentAdminReport getCommentAdminReport(ResultSet resultSet, SolicitudReporte solicitud) throws SQLException {
        int codigo = resultSet.getInt("codigo");
        String nombre = resultSet.getString("nombre");
        int cuenta = resultSet.getInt("cuenta");
        List<CommentAdminSubReport> lista = subListaSuscripciones(codigo, solicitud);

        CommentAdminReport suscriptionReport = new CommentAdminReport(cuenta+"", codigo+"", nombre, lista);
        return suscriptionReport;
    }

}
