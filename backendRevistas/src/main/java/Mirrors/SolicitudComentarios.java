/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mirrors;

/**
 *
 * @author ordson
 */
public class SolicitudComentarios {
    private int autor;
    private int revista;
    private String fechaInicial;
    private String fechaFinal;

    public SolicitudComentarios(int autor, int revista, String fechaInicial, String fechaFinal) {
        this.autor = autor;
        this.revista = revista;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public SolicitudComentarios() {
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public int getRevista() {
        return revista;
    }

    public void setRevista(int revista) {
        this.revista = revista;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SolicitudComentarios{autor=").append(autor);
        sb.append(", revista=").append(revista);
        sb.append(", fechaInicial=").append(fechaInicial);
        sb.append(", fechaFinal=").append(fechaFinal);
        sb.append('}');
        return sb.toString();
    }
    
}
