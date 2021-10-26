/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import Converter.SuscripcionConverter;
import DAO.SuscripcionDAO;
import Modelo.Suscripcion;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ordson
 */
public class subscriber {
    public void suscribir(HttpServletRequest request, HttpServletResponse response, int tiempo) throws IOException{
         String body = new ToBody().convert(request);
        SuscripcionConverter converter = new SuscripcionConverter(Suscripcion.class);
        Suscripcion suscripcion = converter.fromJson(body);
        SuscripcionDAO suscripcionDAO = new SuscripcionDAO();
        suscripcionDAO.suscribirse(suscripcion,tiempo);
        System.out.println(body);
        System.out.println(suscripcion.toString());
        response.getWriter().append(converter.toJson(suscripcionDAO.listarCodigoUsuario(suscripcion.getUsuarioCodigo(), suscripcion.getRevistaCodigo())));
    }
}
