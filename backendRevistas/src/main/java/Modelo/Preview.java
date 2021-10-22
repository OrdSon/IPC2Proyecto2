/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ordson
 */
public class Preview {
    private int codigo;
    private String nombre;
    private String descripcion;
    private String fechaPublicacion;
    private int numero;
    private int likes;
    private int revistaCodigo;
    private String archivo;
    private double precio;
    private String autor;
    private String email;
    private String revista;

    public Preview(int codigo, String nombre, String descripcion, String fechaPublicacion, int numero, int likes, int revistaCodigo, String archivo, double precio, String autor, String email, String revista) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.numero = numero;
        this.likes = likes;
        this.revistaCodigo = revistaCodigo;
        this.archivo = archivo;
        this.precio = precio;
        this.autor = autor;
        this.email = email;
        this.revista = revista;
    }

    public Preview() {
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

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
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

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        sb.append("Preview{codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", fechaPublicacion=").append(fechaPublicacion);
        sb.append(", numero=").append(numero);
        sb.append(", likes=").append(likes);
        sb.append(", revistaCodigo=").append(revistaCodigo);
        sb.append(", archivo=").append(archivo);
        sb.append(", precio=").append(precio);
        sb.append(", autor=").append(autor);
        sb.append(", email=").append(email);
        sb.append(", revista=").append(revista);
        sb.append('}');
        return sb.toString();
    }
    
}
