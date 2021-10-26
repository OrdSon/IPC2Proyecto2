/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportControllers;

import ReportObjects.CommentReport;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author ordson
 */
public class CommentReportController {

    public void generarReporte(HttpServletRequest request, HttpServletResponse response, List<CommentReport> reportes) {

        try {
            for (int i = 0; i < reportes.size(); i++) {
                System.out.println(reportes.get(i));
            }


            System.out.println("path para exportacion: " + request.getServletContext().getRealPath("src/main/webbapp/Resorces/comentarios.jrxml\n"));
            File file = new File(request.getServletContext().getRealPath("/Resorces/comentarios.jrxml"));

            System.out.println(file.getAbsolutePath());
            System.out.println(file.getPath());
            
            JasperReport jasperReports = JasperCompileManager.compileReport(file.getAbsolutePath());


            JRDataSource source = new JRBeanCollectionDataSource(reportes);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReports, null, source);

            
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
            System.out.println("SI?");
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException ex) {
            System.out.println("Error al buscar archivo del reporte");
        } catch (JRException ex) {
            System.out.println(ex.toString());
            System.out.println("Error al compilar el reporte");
        }
    }
}
