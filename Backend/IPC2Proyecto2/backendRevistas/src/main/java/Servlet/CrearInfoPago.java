/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.InfoPagoConverter;
import DAO.InfoPagoDAO;
import Modelo.InfoPago;
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
public class CrearInfoPago extends HttpServlet {
    InfoPagoDAO infoPagoDAO = new InfoPagoDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String body = new ToBody().convert(request);
        InfoPagoConverter converter = new InfoPagoConverter(InfoPago.class);
        InfoPago modelo = converter.fromJson(body);
        System.out.println("MODELOOO"+modelo.toString());
        infoPagoDAO.añadir(modelo);
        
        response.getWriter().append(converter.toJson(infoPagoDAO.listarCodigo(modelo.getusuarioCodigo())));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
