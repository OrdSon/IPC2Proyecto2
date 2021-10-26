/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Magazine;

import Converter.RevistaConverter;
import DAO.RevistaDAO;
import Modelo.Revista;
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
public class New extends HttpServlet {

    RevistaDAO revistaDAO = new RevistaDAO();

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
        RevistaConverter converter = new RevistaConverter(Revista.class);

        Revista model = converter.fromJson(body);

        System.out.println("object");
        System.out.println(model.toString());
        revistaDAO.añadir(model);
        response.getWriter().append(converter.toJson(revistaDAO.listarCodigo(revistaDAO.ultimoCodigo())));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
