/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ordson
 */
public class Caja {
    private int codigo;
    private double capital;

    public Caja(int codigo, double capital) {
        this.codigo = codigo;
        this.capital = capital;
    }

    public Caja(double capital) {
        this.capital = capital;
    }

    public Caja() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Caja{" + "codigo=" + codigo + ", capital=" + capital + '}';
    }
    
}
