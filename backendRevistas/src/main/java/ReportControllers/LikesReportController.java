/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportControllers;

import ReportObjects.LikesReport;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author ordson
 */
public class LikesReportController {
    public void generarReporte(HttpServletRequest request, HttpServletResponse response, List<LikesReport> reportes) {

        try {
            for (int i = 0; i < reportes.size(); i++) {
                System.out.println(reportes.get(i));
            }

            
            
            InputStream compiledReport = getClass().getClassLoader().getResourceAsStream("compilados/likes_report.jasper");            
            
            JRDataSource source = new JRBeanCollectionDataSource(reportes);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(compiledReport, null, source);
            
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
            
            
            System.out.println("SI en suscripciones?");
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
