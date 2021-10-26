/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportObjects;

/**
 *
 * @author ordson
 */
public class GananciasAnuncianteSubReport {

    private String anuncio;
    private String nombre;
    private String fecha;
    private String horas;
    private String monto;

    public GananciasAnuncianteSubReport(String anuncio, String nombre, String fecha, String horas, String monto) {
        this.anuncio = anuncio;
        this.nombre = nombre;
        this.fecha = fecha;
        this.horas = horas;
        this.monto = monto;
    }

    public GananciasAnuncianteSubReport() {
    }

    public String getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(String anuncio) {
        this.anuncio = anuncio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GananciasAnuncianteSubReport{anuncio=").append(anuncio);
        sb.append(", nombre=").append(nombre);
        sb.append(", fecha=").append(fecha);
        sb.append(", horas=").append(horas);
        sb.append(", monto=").append(monto);
        sb.append('}');
        return sb.toString();
    }
    
    

}
