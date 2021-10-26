/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ordson
 */
public class Publico {
    private int anuncioCodigo;
    private int tagCodigo;

    public Publico(int anuncioCodigo, int tagCodigo) {
        this.anuncioCodigo = anuncioCodigo;
        this.tagCodigo = tagCodigo;
    }

    public Publico() {
    }

    public int getAnuncioCodigo() {
        return anuncioCodigo;
    }

    public void setAnuncioCodigo(int anuncioCodigo) {
        this.anuncioCodigo = anuncioCodigo;
    }

    public int getTagCodigo() {
        return tagCodigo;
    }

    public void setTagCodigo(int tagCodigo) {
        this.tagCodigo = tagCodigo;
    }

    @Override
    public String toString() {
        return "Publico{" + "anuncioCodigo=" + anuncioCodigo + ", tagCodigo=" + tagCodigo + '}';
    }
    
}
