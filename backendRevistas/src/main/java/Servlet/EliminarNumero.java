/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.NumeroConverter;
import DAO.NumeroDAO;
import Modelo.Numero;
import Utilidades.ToBody;
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
public class EliminarNumero extends HttpServlet {

    NumeroDAO numeroDAO = new NumeroDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String body = new ToBody().convert(request);
        NumeroConverter converter = new NumeroConverter(Numero.class);
        Numero modelo = converter.fromJson(body);
        System.out.println(modelo.toString());
        numeroDAO.eliminar(modelo.getCodigo());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
