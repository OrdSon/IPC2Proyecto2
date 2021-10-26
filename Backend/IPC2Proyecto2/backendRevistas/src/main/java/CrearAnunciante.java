/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Converter.AnuncianteConverter;
import DAO.AnuncianteDAO;
import Modelo.Anunciante;
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
public class CrearAnunciante extends HttpServlet {

    AnuncianteDAO anuncianteDAO = new AnuncianteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Anunciante> todos = anuncianteDAO.listar();
        Gson gson = new Gson();
        response.getWriter().append(gson.toJson(todos));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String body = new ToBody().convert(request);
        AnuncianteConverter converter = new AnuncianteConverter(Anunciante.class);
        Anunciante anunciante = converter.fromJson(body);
        if (anunciante != null) {
            anuncianteDAO.añadir(anunciante);
            Anunciante nuevo = anuncianteDAO.listarCodigo(anuncianteDAO.ultimoCodigo());
            response.getWriter().append(converter.toJson(nuevo));
        }
        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
