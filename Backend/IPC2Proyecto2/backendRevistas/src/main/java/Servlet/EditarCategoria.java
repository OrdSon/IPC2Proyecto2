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
public class EditarCategoria extends HttpServlet {

    CategoriaDAO categoriaDAO = new CategoriaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String body = new ToBody().convert(request);
        CategoriaConverter converter = new CategoriaConverter(Categoria.class);
        Categoria modelo = converter.fromJson(body);
        System.out.println(modelo.toString());
        categoriaDAO.editar(modelo);
        response.getWriter().append(converter.toJson(categoriaDAO.listarCodigo(modelo.getCodigo())));
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
