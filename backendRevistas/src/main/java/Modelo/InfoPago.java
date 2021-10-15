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
public class InfoPago {
        private int codigo;
	private String tarjeta;
	private String cuenta_bancaria;
	private LocalDate vencimiento; 
	private int usuario_codigo; 

    public InfoPago(int codigo, String tarjeta, String cuenta_bancaria, LocalDate vencimiento, int usuario_codigo) {
        this.codigo = codigo;
        this.tarjeta = tarjeta;
        this.cuenta_bancaria = cuenta_bancaria;
        this.vencimiento = vencimiento;
        this.usuario_codigo = usuario_codigo;
    }

    public InfoPago(String tarjeta, String cuenta_bancaria, LocalDate vencimiento, int usuario_codigo) {
        this.tarjeta = tarjeta;
        this.cuenta_bancaria = cuenta_bancaria;
        this.vencimiento = vencimiento;
        this.usuario_codigo = usuario_codigo;
    }

    public InfoPago(String tarjeta, String cuenta_bancaria, LocalDate vencimiento) {
        this.tarjeta = tarjeta;
        this.cuenta_bancaria = cuenta_bancaria;
        this.vencimiento = vencimiento;
    }

    public InfoPago() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getCuenta_bancaria() {
        return cuenta_bancaria;
    }

    public void setCuenta_bancaria(String cuenta_bancaria) {
        this.cuenta_bancaria = cuenta_bancaria;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
    }

    public int getUsuario_codigo() {
        return usuario_codigo;
    }

    public void setUsuario_codigo(int usuario_codigo) {
        this.usuario_codigo = usuario_codigo;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "infoPago{" + "codigo=" + codigo + ", tarjeta=" + tarjeta + ", cuenta_bancaria=" + cuenta_bancaria + ", vencimiento=" + vencimiento + ", usuario_codigo=" + usuario_codigo + '}';
    }
        
        
}
