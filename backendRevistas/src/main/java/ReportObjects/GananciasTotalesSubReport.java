/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportObjects;

/**
 *
 * @author ordson
 */
public class GananciasTotalesSubReport {
    private String tipo;
    private String monto;
    private String fecha;

    public GananciasTotalesSubReport(String tipo, String monto, String fecha) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
    }

    public GananciasTotalesSubReport() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
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
        sb.append("GananciasTotalesSubReport{tipo=").append(tipo);
        sb.append(", monto=").append(monto);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }
    
}
