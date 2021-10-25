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
public class LikesReport {
    
    private String codigo;
    private String nombreRevista;
    private String cantidadLikes;
    private List<LikesSubReport> registros;

    public LikesReport(String codigo, String nombreRevista, String cantidadLikes, List<LikesSubReport> registros) {
        this.codigo = codigo;
        this.nombreRevista = nombreRevista;
        this.cantidadLikes = cantidadLikes;
        this.registros = registros;
    }

    public LikesReport() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public String getCantidadLikes() {
        return cantidadLikes;
    }

    public void setCantidadLikes(String cantidadLikes) {
        this.cantidadLikes = cantidadLikes;
    }

    public List<LikesSubReport> getRegistros() {
        return registros;
    }

    public void setRegistros(List<LikesSubReport> registros) {
        this.registros = registros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LikesReport{codigo=").append(codigo);
        sb.append(", nombreRevista=").append(nombreRevista);
        sb.append(", cantidadLikes=").append(cantidadLikes);
        sb.append(", registros=").append(registros);
        sb.append('}');
        return sb.toString();
    }
    
    
}
