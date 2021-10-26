/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ordson
 */
public class Review {
    private int codigo;
    private int likes;
    private String comentario;
    private int usuarioCodigo;
    private int numeroCodigo;
    private String fecha;

    public Review(int codigo, int likes, String comentario, int usuarioCodigo, int numeroCodigo, String fecha) {
        this.codigo = codigo;
        this.likes = likes;
        this.comentario = comentario;
        this.usuarioCodigo = usuarioCodigo;
        this.numeroCodigo = numeroCodigo;
        this.fecha = fecha;
    }

    public Review() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public void setUsuarioCodigo(int usuarioCodigo) {
        this.usuarioCodigo = usuarioCodigo;
    }

    public int getNumeroCodigo() {
        return numeroCodigo;
    }

    public void setNumeroCodigo(int numeroCodigo) {
        this.numeroCodigo = numeroCodigo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Review{codigo=").append(codigo);
        sb.append(", likes=").append(likes);
        sb.append(", comentario=").append(comentario);
        sb.append(", usuarioCodigo=").append(usuarioCodigo);
        sb.append(", numeroCodigo=").append(numeroCodigo);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }
   
}
