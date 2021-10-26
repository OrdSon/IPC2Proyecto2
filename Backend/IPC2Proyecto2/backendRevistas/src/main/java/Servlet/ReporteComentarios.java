/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ReporteDAO;
import Mirrors.SolicitudReporte;
import ReportControllers.CommentReportController;
import ReportObjects.CommentReport;
import Utilidades.ToSolicitud;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ordson
 */
public class ReporteComentarios extends HttpServlet {

    ReporteDAO reporteDAO = new ReporteDAO();
    CommentReportController controller = new CommentReportController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CommentReport> lista = new ArrayList<>();
        lista.add(new CommentReport("a", "1", "h", "y"));
        lista.add(new CommentReport("b", "3", "b", "q"));
        lista.add(new CommentReport("v", "2", "c", "r"));
        lista.add(new CommentReport("c", "w", "mn", "a"));
        lista.add(new CommentReport("s", "q", "g", "s"));
        controller.generarReporte(request, response, lista);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SolicitudReporte solicitud = new ToSolicitud().convert(request, response);
        
        System.out.println(solicitud.toString());
        if (solicitud.getRevista() == 0) {
            List<CommentReport> lista = reporteDAO.ReporteComentarios(solicitud);
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).toString());
            }
            controller.generarReporte(request, response, lista);
        } else if (solicitud.getRevista() > 0) {
            List<CommentReport> lista = reporteDAO.ReporteComentariosrRevista(solicitud);
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).toString());
            }
            controller.generarReporte(request, response, lista);

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
