/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.LoginCheckConverter;
import Converter.UsuarioConverter;
import DAO.UsuarioDAO;
import Modelo.LoginCheck;
import Modelo.Profile;
import Modelo.Usuario;
import java.io.BufferedReader;
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
public class LoginServlet extends HttpServlet {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String body = "";
        String line = reader.readLine();
        while (line != null) {
            body = body + line;
            line = reader.readLine();
        }
        System.out.println("body:");
        System.out.println(body);
        LoginCheckConverter converter = new LoginCheckConverter(LoginCheck.class);

        LoginCheck model = converter.fromJson(body);
        Usuario encontrado = usuarioDAO.loginCheck(model);
        int codigo = encontrado.getCodigo();
        System.out.println("object");
        System.out.println(model.toString());
        UsuarioConverter usuarioConverter = new UsuarioConverter(Usuario.class);
        response.getWriter().append(usuarioConverter.toJson(encontrado));

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
