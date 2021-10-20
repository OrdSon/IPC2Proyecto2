/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.RevistaConverter;
import DAO.NumeroDAO;
import DAO.RevistaDAO;
import Modelo.Revista;
import Utilidades.ToBody;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ordson
 */
public class BuscarNumerosPorRevista extends HttpServlet {
    RevistaDAO revistaDAO = new RevistaDAO();
    NumeroDAO numeroDAO = new NumeroDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String body = new ToBody().convert(request);
        RevistaConverter converter = new RevistaConverter(Revista.class);
        Revista modelo = converter.fromJson(body);
        List<Revista> revistas = revistaDAO.listarPorAutor(modelo);
            Gson gson = new Gson();
            response.getWriter().append(gson.toJson(revistas));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
