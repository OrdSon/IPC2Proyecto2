/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportControllers;

import ReportObjects.CommentReport;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
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


            System.out.println("path para exportacion: " + request.getServletContext().getRealPath("src/main/webbapp/Resorces/comentarios.jrxml\n"));//los ../ solo funcionana cuando se esté en HTML XD
            //cargas el archivo al servlet, en este caso el jrxml
            //File file = new File(request.getServletContext().getRealPath("/resources/"+(String) request.getSession().getAttribute("nombreArchivo")+".jrxml"));//aquí mandaba a traer el nombre del arch, del atributo de sesión en el que lo guardé
            File file = new File(request.getServletContext().getRealPath("/Resorces/comentarios.jrxml"));

            //creas tu objeto "jasper" al cual le podrás cargas la info
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getPath());
            
            JasperReport jasperReports = JasperCompileManager.compileReport(file.getAbsolutePath());
            //creas el listado, en este caso de tipo object, que contiene la info que deseas se muestre en el reporte

            //Creas el objeto que te permite enviar el listado y utilizar los métodos para obtener la info

            JRDataSource source = new JRBeanCollectionDataSource(reportes);

            //Aquí se establecen los valores de lso parámetros que colcaste en el reporte
            //la diferencia entre los parámetros y los campos en jasperReports, es que los parámetros son estáticos, solo puede
            //recibir info una vez, en cn los campos pueden variar y así mostrar un listado del tipo de nfor que le correponde
           
            //parametros.put("Autor", "OrdSon");

            //aquí creas el objeto que recibe todo lo que ya preparaste antes, para que pueda ser llenado y que tiene la capacidad de ser impreso, en una de muchas formas, p.ej PDF
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReports, null/*(Map<String, Object>)request.getSession().getAttribute("parametros")*/, source);
            //Con esto ya pones a la vista el reporte en la página que corresponda
            
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
