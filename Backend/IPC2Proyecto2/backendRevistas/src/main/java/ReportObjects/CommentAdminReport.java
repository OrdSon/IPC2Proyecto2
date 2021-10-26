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
public class CommentAdminReport {
    private String cantidad;
    private String codigo;
    private String nombre;
    private List<CommentAdminSubReport> registros;

    public CommentAdminReport(String cantidad, String codigo, String nombre, List<CommentAdminSubReport> registros) {
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.nombre = nombre;
        this.registros = registros;
    }

    public CommentAdminReport() {
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
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

    public List<CommentAdminSubReport> getRegistros() {
        return registros;
    }

    public void setRegistros(List<CommentAdminSubReport> registros) {
        this.registros = registros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CommentAdminReport{cantidad=").append(cantidad);
        sb.append(", codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", registros=").append(registros);
        sb.append('}');
        return sb.toString();
    }
    
}
