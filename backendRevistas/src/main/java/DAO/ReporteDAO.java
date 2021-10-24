/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Mirrors.SolicitudComentarios;
import ReportObjects.CommentReport;
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
public class ReporteDAO extends DAO{
    String REPORTE_COMENTARIOS = "SELECT r.fecha , u.nombre, r.comentario, j.nombre as revista FROM numero as n INNER JOIN review as r ON n.codigo = r.numero_codigo\n" +
"INNER JOIN usuario as u ON u.codigo = r.usuario_codigo INNER JOIN revista j ON j.codigo = n.revista_codigo WHERE j.autor = ? AND r.fecha BETWEEN ? AND ?";
    String REPORTE_COMENTARIOS_REVISTA = "SELECT r.fecha, u.nombre, r.comentario, j.nombre as revista FROM numero as n INNER JOIN review as r ON n.codigo = r.numero_codigo\n" +
"INNER JOIN usuario as u ON u.codigo = r.usuario_codigo INNER JOIN revista j ON j.codigo = n.revista_codigo WHERE j.autor = ? j.codigo = ? AND r.fecha BETWEEN ? AND ?";
    
    
    public List<CommentReport> ReporteComentarios(SolicitudComentarios solicitudComentarios) {
            ArrayList<CommentReport> registros = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(REPORTE_COMENTARIOS);
            preparedStatement.setInt(1, solicitudComentarios.getAutor());
            preparedStatement.setDate(2,Date.valueOf(solicitudComentarios.getFechaInicial()));
            preparedStatement.setDate(3, Date.valueOf(solicitudComentarios.getFechaFinal()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                CommentReport CommentReport = getCommentReport(resultSet);
                if (CommentReport != null) {
                    registros.add(CommentReport);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
    public List<CommentReport> ReporteComentariosrRevista(SolicitudComentarios solicitudComentarios) {
            ArrayList<CommentReport> registros = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(REPORTE_COMENTARIOS);
            preparedStatement.setInt(1, solicitudComentarios.getAutor());
            preparedStatement.setInt(2, solicitudComentarios.getRevista());
            preparedStatement.setDate(3,Date.valueOf(solicitudComentarios.getFechaInicial()));
            preparedStatement.setDate(4, Date.valueOf(solicitudComentarios.getFechaFinal()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                CommentReport CommentReport = getCommentReport(resultSet);
                if (CommentReport != null) {
                    registros.add(CommentReport);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
    public CommentReport getCommentReport(ResultSet resultSet) throws SQLException{
        String fecha = resultSet.getDate("fecha").toString();
        String nombre = resultSet.getString("nombre");
        String comentario = resultSet.getString("comentario");
        String revista = resultSet.getString("revista");
        
        return new CommentReport(fecha, comentario, nombre, revista);
    }
}
