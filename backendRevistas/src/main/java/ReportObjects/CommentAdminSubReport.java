/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportObjects;

/**
 *
 * @author ordson
 */
public class CommentAdminSubReport {
    private String numero;
    private String nombre;
    private String fecha;
    private String comentario;
    private String numeroCodigo;

    public CommentAdminSubReport(String numeroCodigo, String numero, String nombre, String fecha, String comentario) {
        this.numeroCodigo = numeroCodigo;
        this.numero = numero;
        this.nombre = nombre;
        this.fecha = fecha;
        this.comentario = comentario;
    }

    public CommentAdminSubReport() {
    }

    public String getNumeroCodigo() {
        return numeroCodigo;
    }

    public void setNumeroCodigo(String numeroCodigo) {
        this.numeroCodigo = numeroCodigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CommentAdminSubReport{numeroCodigo=").append(numeroCodigo);
        sb.append(", numero=").append(numero);
        sb.append(", nombre=").append(nombre);
        sb.append(", fecha=").append(fecha);
        sb.append(", comentario=").append(comentario);
        sb.append('}');
        return sb.toString();
    }
    
}
