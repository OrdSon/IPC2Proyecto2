/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ReporteComentariosAdminDAO;
import Mirrors.SolicitudReporte;
import ReportControllers.CommentAdminReportController;
import ReportControllers.LikesReportController;
import ReportObjects.CommentAdminReport;
import ReportObjects.LikesReport;
import Utilidades.ToSolicitud;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ordson
 */
public class ReporteComentariosAdmin extends HttpServlet {

    CommentAdminReportController controller = new CommentAdminReportController();
    ReporteComentariosAdminDAO reporteDAO = new ReporteComentariosAdminDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SolicitudReporte solicitud = new ToSolicitud().convert(request, response);
        if (solicitud != null) {
            List<CommentAdminReport> registros = reporteDAO.ReporteComentarios(solicitud);
            controller.generarReporte(request, response, registros);
        }
    }
}
