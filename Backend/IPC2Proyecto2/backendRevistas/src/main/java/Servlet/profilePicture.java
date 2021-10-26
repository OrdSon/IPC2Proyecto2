/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ProfileDAO;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ordson
 */
public class profilePicture extends HttpServlet {
    ProfileDAO profileDAO = new ProfileDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part filePart = request.getPart("datafile");
        String fileName = filePart.getHeader("Content-type");
        InputStream fileStream = filePart.getInputStream();
        System.out.println(fileName);
        System.out.println(filePart.getHeader("Content-disposition"));
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
