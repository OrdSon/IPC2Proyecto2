/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.SuscripcionConverter;
import DAO.SuscripcionDAO;
import Modelo.Suscripcion;
import Utilidades.ToBody;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ordson
 */
public class CancelarSuscripcion extends HttpServlet {
    SuscripcionDAO suscripcionDAO = new SuscripcionDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String body = new ToBody().convert(request);
        SuscripcionConverter converter = new SuscripcionConverter(Suscripcion.class);
        Suscripcion suscripcion = converter.fromJson(body);
        suscripcionDAO.eliminar(suscripcion.getCodigo());
        response.getWriter().append(converter.toJson(suscripcionDAO.listarCodigo(suscripcion.getCodigo())));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
