/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Blob;

/**
 *
 * @author ordson
 */
public class Anuncio {
    private int codigo;
    private String nombre;
    private int horas;
    private Blob archivo;
    private int anuncianteCodigo;

    public Anuncio(int codigo, String nombre, int horas, Blob archivo, int anuncianteCodigo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horas = horas;
        this.archivo = archivo;
        this.anuncianteCodigo = anuncianteCodigo;
    }

    public Anuncio(String nombre, int horas, Blob archivo, int anuncianteCodigo) {
        this.nombre = nombre;
        this.horas = horas;
        this.archivo = archivo;
        this.anuncianteCodigo = anuncianteCodigo;
    }

    public Anuncio(String nombre, int horas, Blob archivo) {
        this.nombre = nombre;
        this.horas = horas;
        this.archivo = archivo;
    }

    public Anuncio() {
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

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Blob getArchivo() {
        return archivo;
    }

    public void setArchivo(Blob archivo) {
        this.archivo = archivo;
    }

    public int getAnuncianteCodigo() {
        return anuncianteCodigo;
    }

    public void setAnuncianteCodigo(int anuncianteCodigo) {
        this.anuncianteCodigo = anuncianteCodigo;
    }

    @Override
    public String toString() {
        return "Archivo{" + "codigo=" + codigo + ", nombre=" + nombre + ", horas=" + horas + ", archivo=" + archivo + ", anuncianteCodigo=" + anuncianteCodigo + '}';
    }
    
}
