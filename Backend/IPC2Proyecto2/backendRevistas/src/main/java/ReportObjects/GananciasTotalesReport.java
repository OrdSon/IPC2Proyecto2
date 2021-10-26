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
public class GananciasTotalesReport {
    private String fecha;
    private String monto;
    private List<GananciasTotalesSubReport> registros;

    public GananciasTotalesReport(String fecha, String monto, List<GananciasTotalesSubReport> registros) {
        this.fecha = fecha;
        this.monto = monto;
        this.registros = registros;
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

    public List<GananciasTotalesSubReport> getRegistros() {
        return registros;
    }

    public void setRegistros(List<GananciasTotalesSubReport> registros) {
        this.registros = registros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GananciasTotalesReport{fecha=").append(fecha);
        sb.append(", monto=").append(monto);
        sb.append(", registros=").append(registros);
        sb.append('}');
        return sb.toString();
    }
    
    
}
