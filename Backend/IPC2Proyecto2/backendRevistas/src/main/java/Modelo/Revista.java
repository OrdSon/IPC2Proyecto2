/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


/**
 *
 * @author ordson
 */
public class Revista {
    private int codigo;
    private String nombre;
    private String descripcion;
    private String fecha;
    private int autor;
    private Double precio;

    public Revista(int codigo, String nombre, String descripcion, String fecha, int autor, Double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.autor = autor;
        this.precio = precio;
    }

    public Revista(String nombre, String descripcion, String fecha, int autor, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.autor = autor;
        this.precio = precio;
    }

    public Revista() {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Revista{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", autor=" + autor + ", precio=" + precio + '}';
    }
    
    
}
