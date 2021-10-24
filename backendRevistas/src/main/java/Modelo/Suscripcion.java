/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


/**
 *
 * @author ordson
 */
public class Suscripcion {
    private int codigo;
    private int usuarioCodigo;
    private int revistaCodigo;
    private String fecha;
    private String estado;
    private int pagos;
    private String proximoPago;
    private String Revista;

    public Suscripcion(int codigo, int usuarioCodigo, int revistaCodigo, String fecha, String estado, int pagos, String proximoPago, String Revista) {
        this.codigo = codigo;
        this.usuarioCodigo = usuarioCodigo;
        this.revistaCodigo = revistaCodigo;
        this.fecha = fecha;
        this.estado = estado;
        this.pagos = pagos;
        this.proximoPago = proximoPago;
        this.Revista = Revista;
    }


    
    public Suscripcion() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPagos() {
        return pagos;
    }

    public void setPagos(int pagos) {
        this.pagos = pagos;
    }

    public String getProximoPago() {
        return proximoPago;
    }

    public void setProximoPago(String proximoPago) {
        this.proximoPago = proximoPago;
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

    public int getRevistaCodigo() {
        return revistaCodigo;
    }

    public void setRevistaCodigo(int revistaCodigo) {
        this.revistaCodigo = revistaCodigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }



    public String getRevista() {
        return Revista;
    }

    public void setRevista(String Revista) {
        this.Revista = Revista;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Suscripcion{codigo=").append(codigo);
        sb.append(", usuarioCodigo=").append(usuarioCodigo);
        sb.append(", revistaCodigo=").append(revistaCodigo);
        sb.append(", fecha=").append(fecha);
        sb.append(", estado=").append(estado);
        sb.append(", pagos=").append(pagos);
        sb.append(", proximoPago=").append(proximoPago);
        sb.append(", Revista=").append(Revista);
        sb.append('}');
        return sb.toString();
    }

    
}
