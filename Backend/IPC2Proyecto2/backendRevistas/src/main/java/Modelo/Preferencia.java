/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ordson
 */
public class Preferencia {
    private int codigo;
    private int usuarioCodigo;
    private int categoriaCodigo;

    public Preferencia(int codigo, int usuarioCodigo, int categoriaCodigo) {
        this.codigo = codigo;
        this.usuarioCodigo = usuarioCodigo;
        this.categoriaCodigo = categoriaCodigo;
    }

    public Preferencia(int usuarioCodigo, int categoriaCodigo) {
        this.usuarioCodigo = usuarioCodigo;
        this.categoriaCodigo = categoriaCodigo;
    }

    public Preferencia() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public void setUsuarioCodigo(int usuarioCodigo) {
        this.usuarioCodigo = usuarioCodigo;
    }

    public int getCategoriaCodigo() {
        return categoriaCodigo;
    }

    public void setCategoriaCodigo(int categoriaCodigo) {
        this.categoriaCodigo = categoriaCodigo;
    }

    @Override
    public String toString() {
        return "Preferencia{" + "codigo=" + codigo + ", usuarioCodigo=" + usuarioCodigo + ", categoriaCodigo=" + categoriaCodigo + '}';
    }
    
}
