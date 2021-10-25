/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportObjects;

/**
 *
 * @author ordson
 */
public class SuscriptionSubReport {
    private String usuario;
    private String fecha;
    private String costo;

    public SuscriptionSubReport(String usuario, String fecha, String costo) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.costo = costo;
    }

    public SuscriptionSubReport() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SuscriptionSubReport{usuario=").append(usuario);
        sb.append(", fecha=").append(fecha);
        sb.append(", costo=").append(costo);
        sb.append('}');
        return sb.toString();
    }
    
    
}
