/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.SettingsConverter;
import DAO.SettingDAO;
import Modelo.Setting;
import Utilidades.ToBody;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ordson
 */
public class EnviarSettings extends HttpServlet {

    SettingDAO settingDAO = new SettingDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(settingDAO.listarCodigo(1));
        response.getWriter().append(new Gson().toJson(settingDAO.listarCodigo(1)));
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String body = new ToBody().convert(request);
        SettingsConverter settingsConverter = new SettingsConverter(Setting.class);
        Setting nuevo = settingsConverter.fromJson(body);
        settingDAO.añadir(nuevo);
        response.getWriter().append(settingsConverter.toJson(settingDAO.listarCodigo(1)));
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
