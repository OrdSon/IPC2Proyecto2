/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.SolicitudSuscripcionesConverter;
import DAO.ReporteSuscripcionesDAO;
import Mirrors.SolicitudSuscripciones;
import ReportControllers.SuscripcionReportController;
import ReportObjects.SuscriptionReport;
import ReportObjects.SuscriptionSubReport;
import Utilidades.ToBody;
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
public class ReporteSuscripciones extends HttpServlet {

    ReporteSuscripcionesDAO reporteDAO = new ReporteSuscripcionesDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<SuscriptionReport> lista = new ArrayList<>();
        List<SuscriptionSubReport> sub1 = new ArrayList<>();
        sub1.add(new SuscriptionSubReport("usu", "fe", "123"));
        sub1.add(new SuscriptionSubReport("uarr", "fzxve", "133"));
        sub1.add(new SuscriptionSubReport("rea", "1455", "143"));
        sub1.add(new SuscriptionSubReport("usc", "agaa", "153"));
        List<SuscriptionSubReport> sub2 = new ArrayList<>();
        sub2.add(new SuscriptionSubReport("ads", "feb", "223"));
        sub2.add(new SuscriptionSubReport("dga", "jhg", "233"));
        sub2.add(new SuscriptionSubReport("xcvb", "fdhg", "243"));
        sub2.add(new SuscriptionSubReport("fhdg", "123", "253"));
        List<SuscriptionSubReport> sub3 = new ArrayList<>();
        sub3.add(new SuscriptionSubReport("ñlkj", "hgf", "343"));
        sub3.add(new SuscriptionSubReport("mnbv", "bvc", "353"));
        lista.add(new SuscriptionReport("2", "revista1", sub1));
        lista.add(new SuscriptionReport("3", "revistaaa2", sub2));
        lista.add(new SuscriptionReport("4", "revisteee5", sub3));
        new SuscripcionReportController().generarReporte(request, response, lista);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String body = new ToBody().convert(request);
        SolicitudSuscripcionesConverter converter = new SolicitudSuscripcionesConverter(SolicitudSuscripciones.class);
        SolicitudSuscripciones solicitud = converter.fromJson(body);
        if (solicitud != null) {
            List<SuscriptionReport> reportes = reporteDAO.ReporteSuscripciones(solicitud);
            new SuscripcionReportController().generarReporte(request, response, reportes);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
