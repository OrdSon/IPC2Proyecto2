/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ReporteGananciasTotalesDAO;
import Mirrors.SolicitudReporte;
import ReportControllers.ReporteGananciasTotalesController;
import ReportObjects.GananciasTotalesReport;
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
public class ReporteGananciasTotales extends HttpServlet {

    ReporteGananciasTotalesDAO DAO = new ReporteGananciasTotalesDAO();
    ReporteGananciasTotalesController controller = new ReporteGananciasTotalesController();
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SolicitudReporte solicitud = new ToSolicitud().convert(request, response);
        if (solicitud != null) {
            List<GananciasTotalesReport> lista = DAO.ReporteGanancias(solicitud);
            System.out.println(DAO.getTotal()+"TOTAAAAAAALLL");
            controller.generarReporte(request, response, lista, DAO.getTotal());
        }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
