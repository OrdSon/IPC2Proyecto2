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
public class GananciasRevistaAdminReport {
    private String codigo;
    private String nombre;
    private String costo;
    private String cobro;
    private String suma;
    private List<GananciasAdminSubReport> registros;

    public GananciasRevistaAdminReport(String codigo, String nombre, String costo, String cobro, String suma, List<GananciasAdminSubReport> registros) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
        this.cobro = cobro;
        this.suma = suma;
        this.registros = registros;
    }

    public GananciasRevistaAdminReport() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getCobro() {
        return cobro;
    }

    public void setCobro(String cobro) {
        this.cobro = cobro;
    }

    public String getSuma() {
        return suma;
    }

    public void setSuma(String suma) {
        this.suma = suma;
    }

    public List<GananciasAdminSubReport> getRegistros() {
        return registros;
    }

    public void setRegistros(List<GananciasAdminSubReport> registros) {
        this.registros = registros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GananciasRevistaAdminReport{codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", costo=").append(costo);
        sb.append(", cobro=").append(cobro);
        sb.append(", suma=").append(suma);
        sb.append(", registros=").append(registros);
        sb.append('}');
        return sb.toString();
    }
    
}
