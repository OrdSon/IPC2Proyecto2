/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ordson
 */
public class Tag {
    private int codigo;
    private String nombre;

    public Tag(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Tag(String nombre) {
        this.nombre = nombre;
    }

    public Tag() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tag{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
}
