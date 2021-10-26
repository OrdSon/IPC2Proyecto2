/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ReporteGananciasPorRevistaDAO;
import Mirrors.SolicitudReporte;
import ReportControllers.GananciasRevistasAdminReportController;
import ReportObjects.GananciasRevistaAdminReport;
import Utilidades.ToSolicitud;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ordson
 */
public class ReporteGananciasRevistas extends HttpServlet {
    ReporteGananciasPorRevistaDAO reporteDAO = new ReporteGananciasPorRevistaDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SolicitudReporte solicitud = new ToSolicitud().convert(request, response);
        if (solicitud != null) {
            List<GananciasRevistaAdminReport> lista = reporteDAO.ReporteGanancias(solicitud);
            new GananciasRevistasAdminReportController().generarReporte(request, response, lista, reporteDAO.getIngreso(), reporteDAO.getGanancia());
        }
    }
}
