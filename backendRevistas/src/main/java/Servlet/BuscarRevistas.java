/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.RevistaDAO;
import Modelo.Revista;
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
public class BuscarRevistas extends HttpServlet {

    RevistaDAO revistaDAO = new RevistaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String body = new ToBody().convert(request);
        List<Revista> all = revistaDAO.listar();
        Gson s = new Gson();
        response.getWriter().append(s.toJson(all));

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
