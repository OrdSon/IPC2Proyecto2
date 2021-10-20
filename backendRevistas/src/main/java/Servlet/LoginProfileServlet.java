/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.ProfileConverter;
import Converter.UsuarioConverter;
import DAO.ProfileDAO;
import Modelo.Profile;
import Modelo.Usuario;
import Utilidades.ToBody;
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
public class LoginProfileServlet extends HttpServlet {

    ProfileDAO profileDAO = new ProfileDAO();

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
        ProfileConverter profileConverter = new ProfileConverter(Profile.class);
        Usuario model = converter.fromJson(body);
        int codigo = model.getCodigo();
        Profile profile = profileDAO.listarCodigo(codigo);

        System.out.println("perfil");
        System.out.println(profile.toString());
        response.getWriter().append(profileConverter.toJson(profile));
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
