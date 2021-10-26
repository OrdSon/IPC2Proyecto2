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
public class Cuota {
    private int codigo;
    private double monto;
    private LocalDate fecha;
    private int revistaCodigo;

    public Cuota(int codigo, double monto, LocalDate fecha, int revistaCodigo) {
        this.codigo = codigo;
        this.monto = monto;
        this.fecha = fecha;
        this.revistaCodigo = revistaCodigo;
    }

    public Cuota(double monto, LocalDate fecha, int revistaCodigo) {
        this.monto = monto;
        this.fecha = fecha;
        this.revistaCodigo = revistaCodigo;
    }

    public Cuota() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getRevistaCodigo() {
        return revistaCodigo;
    }

    public void setRevistaCodigo(int revistaCodigo) {
        this.revistaCodigo = revistaCodigo;
    }

    @Override
    public String toString() {
        return "CuotaDiaria{" + "codigo=" + codigo + ", monto=" + monto + ", fecha=" + fecha + ", revistaCodigo=" + revistaCodigo + '}';
    }
    
    
}
