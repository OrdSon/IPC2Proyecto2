/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Blob;
import java.time.LocalDate;

/**
 *
 * @author ordson
 */
public class Numero {
    private int codigo;
    private String nombre;
    private String descripcion;
    private LocalDate fechaPublicacion;
    private int numero;
    private int likes;
    private int revistaCodigo;
    private Blob archivo;

    public Numero(int codigo, String nombre, String descripcion, LocalDate fechaPublicacion, int numero, int likes, int revistaCodigo, Blob archivo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.numero = numero;
        this.likes = likes;
        this.revistaCodigo = revistaCodigo;
        this.archivo = archivo;
    }

    public Numero(String nombre, String descripcion, LocalDate fechaPublicacion, int numero, int likes, int revistaCodigo, Blob archivo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.numero = numero;
        this.likes = likes;
        this.revistaCodigo = revistaCodigo;
        this.archivo = archivo;
    }

    public Numero(int codigo, String nombre, String descripcion, LocalDate fechaPublicacion, int numero, int likes, int revistaCodigo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.numero = numero;
        this.likes = likes;
        this.revistaCodigo = revistaCodigo;
    }

    public Numero(String nombre, String descripcion, LocalDate fechaPublicacion, int numero, int likes, int revistaCodigo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.numero = numero;
        this.likes = likes;
        this.revistaCodigo = revistaCodigo;
    }

    public Numero(Blob archivo) {
        this.archivo = archivo;
    }

    public Numero() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getRevistaCodigo() {
        return revistaCodigo;
    }

    public void setRevistaCodigo(int revistaCodigo) {
        this.revistaCodigo = revistaCodigo;
    }

    public Blob getArchivo() {
        return archivo;
    }

    public void setArchivo(Blob archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "numero{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaPublicacion=" + fechaPublicacion + ", numero=" + numero + ", likes=" + likes + ", revistaCodigo=" + revistaCodigo + ", archivo=" + archivo + '}';
    }
    
}
