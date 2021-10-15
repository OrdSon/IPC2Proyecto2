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

    public Review(int codigo, int likes, String comentario, int usuarioCodigo, int numeroCodigo) {
        this.codigo = codigo;
        this.likes = likes;
        this.comentario = comentario;
        this.usuarioCodigo = usuarioCodigo;
        this.numeroCodigo = numeroCodigo;
    }

    public Review(int likes, String comentario, int usuarioCodigo, int numeroCodigo) {
        this.likes = likes;
        this.comentario = comentario;
        this.usuarioCodigo = usuarioCodigo;
        this.numeroCodigo = numeroCodigo;
    }

    public int getNumeroCodigo() {
        return numeroCodigo;
    }

    public void setNumeroCodigo(int numeroCodigo) {
        this.numeroCodigo = numeroCodigo;
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

    @Override
    public String toString() {
        return "Review{" + "codigo=" + codigo + ", likes=" + likes + ", comentario=" + comentario + ", usuarioCodigo=" + usuarioCodigo + ", numeroCodigo=" + numeroCodigo + '}';
    }
    
}
