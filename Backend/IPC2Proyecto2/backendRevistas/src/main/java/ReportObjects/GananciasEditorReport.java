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
public class GananciasEditorReport {
    private String subtotal;
    private String codigo;
    private String nombre;
    private String precio;
    private List<GananciasEditorSubReport> subreportes;

    public GananciasEditorReport(String subtotal, String codigo, String nombre, String precio, List<GananciasEditorSubReport> subreportes) {
        this.subtotal = subtotal;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.subreportes = subreportes;
    }

    public GananciasEditorReport() {
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public List<GananciasEditorSubReport> getSubreportes() {
        return subreportes;
    }

    public void setSubreportes(List<GananciasEditorSubReport> subreportes) {
        this.subreportes = subreportes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GananciasEditorReport{subtotal=").append(subtotal);
        sb.append(", codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        sb.append(", subreportes=").append(subreportes);
        sb.append('}');
        return sb.toString();
    }
    
    
}
