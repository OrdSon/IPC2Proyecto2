/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import Converter.SolicitudReporteConverter;
import Mirrors.SolicitudReporte;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ordson
 */
public class ToSolicitud {

    public SolicitudReporte convert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=reporte.pdf");
        String body = new ToBody().convert(request);
        SolicitudReporteConverter conveter = new SolicitudReporteConverter(SolicitudReporte.class);
        SolicitudReporte solicitud = conveter.fromJson(body);
        if (solicitud.getFechaInicial() == null) {
            solicitud.setFechaInicial("2000-01-01");
        }
        if (solicitud.getFechaFinal() == null) {

            solicitud.setFechaFinal("2100-01-01");
        }
        return solicitud;
    }
}
