/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


/**
 *
 * @author ordson
 */
public class Anuncio {
    private int codigo;
    private String nombre;
    private int horas;
    private String archivo;
    private String fecha;
    private int anuncianteCodigo;
    private int veces;
    private String finale;

    public Anuncio(int codigo, String nombre, int horas, String archivo, String fecha, int anuncianteCodigo, int veces, String finale) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horas = horas;
        this.archivo = archivo;
        this.fecha = fecha;
        this.anuncianteCodigo = anuncianteCodigo;
        this.veces = veces;
        this.finale = finale;
    }

    public Anuncio() {
    }

    public String getFinale() {
        return finale;
    }

    public void setFinale(String finale) {
        this.finale = finale;
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

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAnuncianteCodigo() {
        return anuncianteCodigo;
    }

    public void setAnuncianteCodigo(int anuncianteCodigo) {
        this.anuncianteCodigo = anuncianteCodigo;
    }

    public int getVeces() {
        return veces;
    }

    public void setVeces(int veces) {
        this.veces = veces;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Anuncio{codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", horas=").append(horas);
        sb.append(", archivo=").append(archivo);
        sb.append(", fecha=").append(fecha);
        sb.append(", anuncianteCodigo=").append(anuncianteCodigo);
        sb.append(", veces=").append(veces);
        sb.append(", finale=").append(finale);
        sb.append('}');
        return sb.toString();
    }


    
}
