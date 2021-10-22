/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;



/**
 *
 * @author ordson
 */
public class Numero {
    private int codigo;
    private String nombre;
    private String descripcion;
    private String fechaPublicacion;
    private String archivo;
    private int numero;
    private int likes;
    private int revistaCodigo;

    public Numero(int codigo, String nombre, String descripcion, String fechaPublicacion, String archivo, int numero, int likes, int revistaCodigo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.archivo = archivo;
        this.numero = numero;
        this.likes = likes;
        this.revistaCodigo = revistaCodigo;
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

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Numero{codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", fechaPublicacion=").append(fechaPublicacion);
        sb.append(", archivo=").append(archivo);
        sb.append(", numero=").append(numero);
        sb.append(", likes=").append(likes);
        sb.append(", revistaCodigo=").append(revistaCodigo);
        sb.append('}');
        return sb.toString();
    }


    
}
