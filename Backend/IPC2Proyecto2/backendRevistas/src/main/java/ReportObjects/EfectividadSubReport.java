/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportObjects;

/**
 *
 * @author ordson
 */
public class EfectividadSubReport {
    private String anuncio;
    private String veces;
    private String fecha;

    public EfectividadSubReport() {
    }

    public EfectividadSubReport(String anuncio, String veces, String fecha) {
        this.anuncio = anuncio;
        this.veces = veces;
        this.fecha = fecha;
    }

    public String getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(String anuncio) {
        this.anuncio = anuncio;
    }

    public String getVeces() {
        return veces;
    }

    public void setVeces(String veces) {
        this.veces = veces;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EfectividadSubReport{anuncio=").append(anuncio);
        sb.append(", veces=").append(veces);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }
    
}
