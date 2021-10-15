/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ordson
 */
public class Referencia {
    int numeroCodigo;
    int tagCodigo;

    public Referencia(int numeroCodigo, int tagCodigo) {
        this.numeroCodigo = numeroCodigo;
        this.tagCodigo = tagCodigo;
    }

    public Referencia() {
    }

    public int getNumeroCodigo() {
        return numeroCodigo;
    }

    public void setNumeroCodigo(int numeroCodigo) {
        this.numeroCodigo = numeroCodigo;
    }

    public int getTagCodigo() {
        return tagCodigo;
    }

    public void setTagCodigo(int tagCodigo) {
        this.tagCodigo = tagCodigo;
    }

    @Override
    public String toString() {
        return "referencia{" + "numeroCodigo=" + numeroCodigo + ", tagCodigo=" + tagCodigo + '}';
    }
    
}
