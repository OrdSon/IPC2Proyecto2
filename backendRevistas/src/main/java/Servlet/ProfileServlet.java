/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.ProfileConverter;
import DAO.ProfileDAO;
import Modelo.Profile;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ordson
 */
public class ProfileServlet extends HttpServlet {

    ProfileDAO profileDAO = new ProfileDAO();
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
        ProfileConverter converter = new ProfileConverter(Profile.class);

        Profile model = converter.fromJson(body);

        System.out.println("object");
        System.out.println(model.toString());
        profileDAO.añadir(model);
        response.getWriter().append(converter.toJson(model));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}