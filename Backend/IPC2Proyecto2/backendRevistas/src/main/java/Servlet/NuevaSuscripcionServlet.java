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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NuevaSuscripcionServlet extends HttpServlet {
    SuscripcionDAO suscripcionDAO = new SuscripcionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String body = new ToBody().convert(request);
        System.out.println("body:");
        System.out.println(body);
        SuscripcionConverter converter = new SuscripcionConverter(Suscripcion.class);
        
        Suscripcion model = converter.fromJson(body);
        
        System.out.println("object");
        System.out.println(model.toString());
        suscripcionDAO.añadir(model);
        response.getWriter().append(converter.toJson(model));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
