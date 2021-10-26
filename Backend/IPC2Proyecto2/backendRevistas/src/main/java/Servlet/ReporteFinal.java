/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ReporteFinalDAO;
import Mirrors.SolicitudReporte;
import ReportControllers.ReporteFinalController;
import ReportObjects.GananciasAnuncianteReport;
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
public class ReporteFinal extends HttpServlet {

    ReporteFinalController controller = new ReporteFinalController();
    ReporteFinalDAO reporteDAO = new ReporteFinalDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SolicitudReporte solicitudReporte = new ToSolicitud().convert(request, response);
        if (solicitudReporte != null) {
            List<GananciasAnuncianteReport> lista = reporteDAO.ReporteGanancias(solicitudReporte);
            double result = reporteDAO.getTotal();
            controller.generarReporte(request, response, lista, result);
                    
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
