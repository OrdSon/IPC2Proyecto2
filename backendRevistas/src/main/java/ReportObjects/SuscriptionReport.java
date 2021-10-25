/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportObjects;

import java.util.List;

/**
 *
 * @author ordson
 */
public class SuscriptionReport {
    private String codigo;
    private String revista;
    private List<SuscriptionSubReport> suscripciones;

    public SuscriptionReport(String codigo, String revista, List<SuscriptionSubReport> suscripciones) {
        this.codigo = codigo;
        this.revista = revista;
        this.suscripciones = suscripciones;
    }

    public SuscriptionReport() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    public List<SuscriptionSubReport> getSuscripciones() {
        return suscripciones;
    }

    public void setSuscripciones(List<SuscriptionSubReport> suscripciones) {
        this.suscripciones = suscripciones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SuscriptionReport{codigo=").append(codigo);
        sb.append(", revista=").append(revista);
        sb.append(", suscripciones=").append(suscripciones);
        sb.append('}');
        return sb.toString();
    }

   
    
}
