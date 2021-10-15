/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author ordson
 */
public class Cobro {
    private int codigo;
    private int eleccion;
    private int anuncioCodigo;
    private int pagoCodigo;
    private int cuotaDiariaCodigo;
    private double monto;
    private LocalDate fecha;

    public Cobro(int codigo, int fueteCodigo, int eleccion, double monto, LocalDate fecha) {
        this.codigo = codigo;
        this.monto = monto;
        this.fecha = fecha;
        switch(eleccion){
            case 1:
                this.anuncioCodigo = fueteCodigo;
                break;
            case 2:
                this.pagoCodigo = fueteCodigo;
                break;
            case 3:
                this.cuotaDiariaCodigo = fueteCodigo;
                break;
            default:
                this.eleccion = 0;
                break;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEleccion() {
        return eleccion;
    }

    public void setEleccion(int eleccion) {
        this.eleccion = eleccion;
    }

    public int getAnuncioCodigo() {
        return anuncioCodigo;
    }

    public void setAnuncioCodigo(int anuncioCodigo) {
        this.anuncioCodigo = anuncioCodigo;
    }

    public int getPagoCodigo() {
        return pagoCodigo;
    }

    public void setPagoCodigo(int pagoCodigo) {
        this.pagoCodigo = pagoCodigo;
    }

    public int getCuotaDiariaCodigo() {
        return cuotaDiariaCodigo;
    }

    public void setCuotaDiariaCodigo(int cuotaDiariaCodigo) {
        this.cuotaDiariaCodigo = cuotaDiariaCodigo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Cobro{" + "codigo=" + codigo + ", eleccion=" + eleccion + ", anuncioCodigo=" + anuncioCodigo + ", pagoCodigo=" + pagoCodigo + ", cuotaDiariaCodigo=" + cuotaDiariaCodigo + ", monto=" + monto + ", fecha=" + fecha + '}';
    }

    
    
    
    
}
