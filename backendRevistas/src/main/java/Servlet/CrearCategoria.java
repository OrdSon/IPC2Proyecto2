/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.CategoriaConverter;
import DAO.CategoriaDAO;
import Modelo.Categoria;
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
public class CrearCategoria extends HttpServlet {

    CategoriaDAO categoriaDAO = new CategoriaDAO();

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
        CategoriaConverter converter = new CategoriaConverter(Categoria.class);

        Categoria model = converter.fromJson(body);
        
        System.out.println("object");
        System.out.println(model.toString());
        categoriaDAO.añadir(model);
        response.getWriter().append(converter.toJson(model));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
