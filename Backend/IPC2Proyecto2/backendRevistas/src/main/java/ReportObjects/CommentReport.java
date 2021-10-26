/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportObjects;

/**
 *
 * @author ordson
 */
public class CommentReport {
    private String fecha;
    private String comentario;
    private String usuario;
    private String revista;

    public CommentReport(String fecha, String comentario, String usuario, String revista) {
        this.fecha = fecha;
        this.comentario = comentario;
        this.usuario = usuario;
        this.revista = revista;
    }

    public CommentReport() {
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CommentReport{fecha=").append(fecha);
        sb.append(", comentario=").append(comentario);
        sb.append(", usuario=").append(usuario);
        sb.append(", revista=").append(revista);
        sb.append('}');
        return sb.toString();
    }

   
}
