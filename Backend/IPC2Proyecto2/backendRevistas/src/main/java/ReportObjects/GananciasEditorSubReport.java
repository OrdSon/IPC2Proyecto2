/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportObjects;

/**
 *
 * @author ordson
 */
public class GananciasEditorSubReport {
    private String nombre;
    private String fecha;
    private String monto;

    public GananciasEditorSubReport(String nombre, String fecha, String monto) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.monto = monto;
    }

    public GananciasEditorSubReport() {
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

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GananciasEditorSubReport{nombre=").append(nombre);
        sb.append(", fecha=").append(fecha);
        sb.append(", monto=").append(monto);
        sb.append('}');
        return sb.toString();
    }
    
}
