/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.RerporteEfectividadDAO;
import Mirrors.SolicitudReporte;
import ReportControllers.ReporteEfectividadController;
import ReportObjects.EfectividadReport;
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
public class ReporteEfectividad extends HttpServlet {

    ReporteEfectividadController controller = new ReporteEfectividadController();
    RerporteEfectividadDAO reporteDAO = new RerporteEfectividadDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SolicitudReporte solicitud = new ToSolicitud().convert(request, response);
        if (solicitud != null) {
            List<EfectividadReport> lista = reporteDAO.ReporteGanancias(solicitud);
            controller.generarReporte(request, response, lista);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
