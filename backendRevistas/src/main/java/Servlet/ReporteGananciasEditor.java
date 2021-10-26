/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ReporteGananciasEditorDAO;
import Mirrors.SolicitudReporte;
import ReportControllers.GananciasEditorReportController;
import ReportObjects.GananciasEditorReport;
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
public class ReporteGananciasEditor extends HttpServlet {

ReporteGananciasEditorDAO reporteDAO = new ReporteGananciasEditorDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SolicitudReporte solicitud = new ToSolicitud().convert(request, response);
        if (solicitud != null) {
            List<GananciasEditorReport> lista = reporteDAO.ReporteGanancias(solicitud);
            new GananciasEditorReportController().generarReporte(request, response, lista, reporteDAO.getCantidad());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
