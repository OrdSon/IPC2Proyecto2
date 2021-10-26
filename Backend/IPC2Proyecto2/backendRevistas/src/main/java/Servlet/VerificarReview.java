/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Converter.ReviewConverter;
import Converter.RevistaConverter;
import DAO.ReviewDAO;
import Modelo.Review;
import Modelo.Revista;
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
public class VerificarReview extends HttpServlet {
    ReviewDAO reviewDAO = new ReviewDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String body = new ToBody().convert(request);
        System.out.println(body);
        ReviewConverter reviewConverter = new ReviewConverter(Review.class);
        Review review = reviewConverter.fromJson(body);
        System.out.println(review.toString());
        Review validacion = reviewDAO.listarCodigo(review.getUsuarioCodigo(), review.getNumeroCodigo());
        if (validacion != null) {
            response.getWriter().append(reviewConverter.toJson(validacion));
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
