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
public class GananciasAnuncianteReport {
    private String nombre;
    private List<GananciasAnuncianteSubReport> registros;

    public GananciasAnuncianteReport(String nombre, List<GananciasAnuncianteSubReport> registros) {
        this.nombre = nombre;
        this.registros = registros;
    }

    public GananciasAnuncianteReport() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<GananciasAnuncianteSubReport> getRegistros() {
        return registros;
    }

    public void setRegistros(List<GananciasAnuncianteSubReport> registros) {
        this.registros = registros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GananciasAnuncianteReport{nombre=").append(nombre);
        sb.append(", registros=").append(registros);
        sb.append('}');
        return sb.toString();
    }
    
}
