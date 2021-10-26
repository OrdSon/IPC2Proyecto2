/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package DAO;

import Converter.SuscripcionConverter;
import Modelo.Suscripcion;
import Utilidades.ToBody;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ordson
 */
public class VerificarSuscripcion extends HttpServlet {

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
        System.out.println(body);
        System.out.println(suscripcion.toString());
        response.getWriter().append(converter.toJson(suscripcionDAO.listarCodigoUsuario(suscripcion.getUsuarioCodigo(), suscripcion.getRevistaCodigo())));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
