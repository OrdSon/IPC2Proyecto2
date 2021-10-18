/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


/**
 *
 * @author ordson
 */
public class Suscripcion {
    private int codigo;
    private int usuarioCodigo;
    private int revistaCodigo;
    private String fecha;

    public Suscripcion(int codigo, int usuarioCodigo, int revistaCodigo, String fecha) {
        this.codigo = codigo;
        this.usuarioCodigo = usuarioCodigo;
        this.revistaCodigo = revistaCodigo;
        this.fecha = fecha;
    }

    public Suscripcion(int usuarioCodigo, int revistaCodigo, String fecha) {
        this.usuarioCodigo = usuarioCodigo;
        this.revistaCodigo = revistaCodigo;
        this.fecha = fecha;
    }

    public Suscripcion() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public void setUsuarioCodigo(int usuarioCodigo) {
        this.usuarioCodigo = usuarioCodigo;
    }

    public int getRevistaCodigo() {
        return revistaCodigo;
    }

    public void setRevistaCodigo(int revistaCodigo) {
        this.revistaCodigo = revistaCodigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "suscripcion{" + "codigo=" + codigo + ", usuarioCodigo=" + usuarioCodigo + ", revistaCodigo=" + revistaCodigo + ", fecha=" + fecha + '}';
    }
    
}
