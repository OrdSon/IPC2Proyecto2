/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


/**
 *
 * @author ordson
 */
public class Pago {
    private int codigo;
    private String fecha;
    private double monto;
    private int suscripcionCodigo;
    private int usuarioCodigo;

    public Pago(int codigo, String fecha, double monto, int suscripcionCodigo, int usuarioCodigo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.monto = monto;
        this.suscripcionCodigo = suscripcionCodigo;
        this.usuarioCodigo = usuarioCodigo;
    }

    public Pago(String fecha, double monto, int suscripcionCodigo, int usuarioCodigo) {
        this.fecha = fecha;
        this.monto = monto;
        this.suscripcionCodigo = suscripcionCodigo;
        this.usuarioCodigo = usuarioCodigo;
    }

    public Pago() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getSuscripcionCodigo() {
        return suscripcionCodigo;
    }

    public void setSuscripcionCodigo(int suscripcionCodigo) {
        this.suscripcionCodigo = suscripcionCodigo;
    }

    public int getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public void setUsuarioCodigo(int usuarioCodigo) {
        this.usuarioCodigo = usuarioCodigo;
    }

    @Override
    public String toString() {
        return "pago{" + "codigo=" + codigo + ", fecha=" + fecha + ", monto=" + monto + ", suscripcionCodigo=" + suscripcionCodigo + ", usuarioCodigo=" + usuarioCodigo + '}';
    }
    
    
}
