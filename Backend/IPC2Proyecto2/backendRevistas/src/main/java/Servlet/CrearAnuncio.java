/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.AnuncioConverter;
import Converter.SettingsConverter;
import DAO.AnuncioDAO;
import DAO.SettingDAO;
import Modelo.Anuncio;
import Modelo.Setting;
import Utilidades.ToBody;
import com.google.gson.Gson;
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
public class CrearAnuncio extends HttpServlet {

    AnuncioDAO anuncioDAO = new AnuncioDAO();
    SettingDAO settingDAO = new SettingDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Setting setting = settingDAO.listarCodigo(1);
        SettingsConverter converter = new SettingsConverter(Setting.class);
        if (setting != null) {
            response.getWriter().append(converter.toJson(setting));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String body = new ToBody().convert(request);
        AnuncioConverter converter = new AnuncioConverter(Anuncio.class);
        Anuncio nuevo = converter.fromJson(body);
        anuncioDAO.añadir(nuevo);
        response.getWriter().append(converter.toJson(anuncioDAO.listarCodigo(anuncioDAO.ultimoCodigo())));
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
