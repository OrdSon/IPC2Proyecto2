/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.UsuarioConverter;
import DAO.SuscripcionDAO;
import Modelo.Suscripcion;
import Modelo.Usuario;
import Utilidades.ToBody;
import com.google.gson.Gson;
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
public class ListaSuscripciones extends HttpServlet {
    SuscripcionDAO suscripcionDAO = new SuscripcionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String body = new ToBody().convert(request);
         UsuarioConverter converter = new UsuarioConverter(Usuario.class);
        Usuario usuario = converter.fromJson(body);
        System.out.println(body);
        System.out.println(usuario.toString());
        List<Suscripcion> suscripciones = suscripcionDAO.listarPorUsuario(usuario.getCodigo());
        Gson s = new Gson();
        response.getWriter().append(s.toJson(suscripciones));
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
