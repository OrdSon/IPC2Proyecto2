/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ordson
 */
public class Anunciante {
    private int codigo;
    private String nombre;

    public Anunciante(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Anunciante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "anunciante{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
}
