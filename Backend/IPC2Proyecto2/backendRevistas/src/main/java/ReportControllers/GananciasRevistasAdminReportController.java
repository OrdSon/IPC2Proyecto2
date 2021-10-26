/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportControllers;

import ReportObjects.GananciasRevistaAdminReport;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class GananciasRevistasAdminReportController {

    public void generarReporte(HttpServletRequest request, HttpServletResponse response, List<GananciasRevistaAdminReport> reportes, double in, double gains) {

        try {
            for (int i = 0; i < reportes.size(); i++) {
                System.out.println(reportes.get(i));
            }

            Map<String, Object> parametros = new HashMap<>();
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            double ingreso = Double.parseDouble(numberFormat.format(in));
            double ganancia = Double.parseDouble(numberFormat.format(gains));
            parametros.put("ingreso", ingreso);
            parametros.put("ganancia", ganancia);
            
            InputStream compiledReport = getClass().getClassLoader().getResourceAsStream("compilados/reporte_ganancias_revistas_report.jasper");

            JRDataSource source = new JRBeanCollectionDataSource(reportes);

            JasperPrint jasperPrint = JasperFillManager.fillReport(compiledReport, parametros, source);

            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException ex) {
            System.out.println("Error al buscar archivo del reporte");
        } catch (JRException ex) {
            System.out.println(ex.toString());
            System.out.println("Error al compilar el reporte");
        }
        System.out.println("SI, exportado");
    }
}
