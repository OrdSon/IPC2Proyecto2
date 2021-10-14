/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Magazine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.servlet.http.MappingMatch.PATH;
import javax.servlet.http.Part;

/**
 *
 * @author ordson
 */
@MultipartConfig
public class UploadPdf extends HttpServlet {

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
