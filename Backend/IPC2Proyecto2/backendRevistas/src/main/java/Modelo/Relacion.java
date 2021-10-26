/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ordson
 */
public class Relacion {
    private int codigo;
    private int codigoRevista;
    private int codigoCategoria;

    public Relacion(int codigo, int codigoRevista, int codigoCategoria) {
        this.codigo = codigo;
        this.codigoRevista = codigoRevista;
        this.codigoCategoria = codigoCategoria;
    }

    public Relacion(int codigoRevista, int codigoCategoria) {
        this.codigoRevista = codigoRevista;
        this.codigoCategoria = codigoCategoria;
    }

    public Relacion() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoRevista() {
        return codigoRevista;
    }

    public void setCodigoRevista(int codigoRevista) {
        this.codigoRevista = codigoRevista;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    @Override
    public String toString() {
        return "relacion{" + "codigo=" + codigo + ", codigoRevista=" + codigoRevista + ", codigoCategoria=" + codigoCategoria + '}';
    }
    
}
