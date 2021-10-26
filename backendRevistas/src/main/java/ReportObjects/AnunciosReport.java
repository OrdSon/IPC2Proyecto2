/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportObjects;

/**
 *
 * @author ordson
 */
public class AnunciosReport {
    private String codigo; 
    private String anuncio;
    private String veces;
    private String fecha;
    private String dias;
    private String anunciante;

    public AnunciosReport(String codigo, String anuncio, String veces, String fecha, String dia, String anunciante) {
        this.codigo = codigo;
        this.anuncio = anuncio;
        this.veces = veces;
        this.fecha = fecha;
        this.dias = dia;
        this.anunciante = anunciante;
    }

    public AnunciosReport() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getDia() {
        return dias;
    }

    public void setDia(String dia) {
        this.dias = dia;
    }

    public String getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(String anunciante) {
        this.anunciante = anunciante;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnunciosReport{codigo=").append(codigo);
        sb.append(", anuncio=").append(anuncio);
        sb.append(", veces=").append(veces);
        sb.append(", fecha=").append(fecha);
        sb.append(", dia=").append(dias);
        sb.append(", anunciante=").append(anunciante);
        sb.append('}');
        return sb.toString();
    }
    
}
