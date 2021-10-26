/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ordson
 */
public class InfoPago {
        private int codigo;
	private String tarjeta;
	private String cuenta_bancaria;
	private String vencimiento; 
	private int usuarioCodigo; 

    public InfoPago(int codigo, String tarjeta, String cuenta_bancaria, String vencimiento, int usuarioCodigo) {
        this.codigo = codigo;
        this.tarjeta = tarjeta;
        this.cuenta_bancaria = cuenta_bancaria;
        this.vencimiento = vencimiento;
        this.usuarioCodigo = usuarioCodigo;
    }

    public InfoPago(String tarjeta, String cuenta_bancaria, String vencimiento, int usuarioCodigo) {
        this.tarjeta = tarjeta;
        this.cuenta_bancaria = cuenta_bancaria;
        this.vencimiento = vencimiento;
        this.usuarioCodigo = usuarioCodigo;
    }

    public InfoPago(String tarjeta, String cuenta_bancaria, String vencimiento) {
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

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public int getusuarioCodigo() {
        return usuarioCodigo;
    }

    public void setusuarioCodigo(int usuarioCodigo) {
        this.usuarioCodigo = usuarioCodigo;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "infoPago{" + "codigo=" + codigo + ", tarjeta=" + tarjeta + ", cuenta_bancaria=" + cuenta_bancaria + ", vencimiento=" + vencimiento + ", usuarioCodigo=" + usuarioCodigo + '}';
    }
        
        
}
