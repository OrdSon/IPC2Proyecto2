/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.UsuarioConverter;
import DAO.UsuarioDAO;
import Modelo.Usuario;
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
public class AdminServlet extends HttpServlet {
    UsuarioDAO usuarioDAO = new UsuarioDAO();
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
        UsuarioConverter converter = new UsuarioConverter(Usuario.class);
        
        Usuario model = converter.fromJson(body);
        model.setTipo(3);
        model.setNickName(model.getNombre());
        System.out.println("object");
        System.out.println(model.toString());
        usuarioDAO.añadir(model);
        response.getWriter().append(converter.toJson(model));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
