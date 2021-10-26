/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ReporteAnunciosDAO;
import Mirrors.SolicitudReporte;
import ReportControllers.AnunciosReportController;
import ReportObjects.AnunciosReport;
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
public class ReporteAnuncios extends HttpServlet {

    ReporteAnunciosDAO reporteDAO = new ReporteAnunciosDAO();
    AnunciosReportController controller = new AnunciosReportController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SolicitudReporte solicitud = new ToSolicitud().convert(request, response);
        if (solicitud != null) {
            List<AnunciosReport> lista = reporteDAO.ReporteAnuncios(solicitud);
            controller.generarReporte(request, response, lista);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}