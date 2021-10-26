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
public class EfectividadReport {
    private String nombre;
    private List<EfectividadSubReport> registros;

    public EfectividadReport(String nombre, List<EfectividadSubReport> registros) {
        this.nombre = nombre;
        this.registros = registros;
    }

    public List<EfectividadSubReport> getRegistros() {
        return registros;
    }

    public void setRegistros(List<EfectividadSubReport> registros) {
        this.registros = registros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EfectividadReport{nombre=").append(nombre);
        sb.append(", registros=").append(registros);
        sb.append('}');
        return sb.toString();
    }
    
}
