/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportObjects;

/**
 *
 * @author ordson
 */
public class GananciasAdminSubReport {
    private String nombre;
    private String fecha;
    private String precio;
    private String monto;

    public GananciasAdminSubReport(String nombre, String fecha, String precio, String monto) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.precio = precio;
        this.monto = monto;
    }

    public GananciasAdminSubReport() {
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
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
        sb.append("GananciasAdminSubReport{nombre=").append(nombre);
        sb.append(", fecha=").append(fecha);
        sb.append(", precio=").append(precio);
        sb.append(", monto=").append(monto);
        sb.append('}');
        return sb.toString();
    }
    
}
