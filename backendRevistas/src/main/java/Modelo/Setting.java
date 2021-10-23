/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ordson
 */
public class Setting {
    private int codigo;
    private double porcentajeCobro;
    private double cuotaDiaria;
    private double precioHoraAnuncio;

    public Setting(int codigo, double porcentajeCobro, double cuotaDiaria, double precioHoraAnuncio) {
        this.codigo = codigo;
        this.porcentajeCobro = porcentajeCobro;
        this.cuotaDiaria = cuotaDiaria;
        this.precioHoraAnuncio = precioHoraAnuncio;
    }

    public Setting(double porcentajeCobro, double cuotaDiaria, double precioHoraAnuncio) {
        this.porcentajeCobro = porcentajeCobro;
        this.cuotaDiaria = cuotaDiaria;
        this.precioHoraAnuncio = precioHoraAnuncio;
    }

    public Setting() {
    }

    public double getPrecioHoraAnuncio() {
        return precioHoraAnuncio;
    }

    public void setPrecioHoraAnuncio(double precioHoraAnuncio) {
        this.precioHoraAnuncio = precioHoraAnuncio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPorcentajeCobro() {
        return porcentajeCobro;
    }

    public void setPorcentajeCobro(double porcentajeCobro) {
        this.porcentajeCobro = porcentajeCobro;
    }

    public double getCuotaDiaria() {
        return cuotaDiaria;
    }

    public void setCuotaDiaria(double cuotaDiaria) {
        this.cuotaDiaria = cuotaDiaria;
    }

    @Override
    public String toString() {
        return "Setting{" + "codigo=" + codigo + ", porcentajeCobro=" + porcentajeCobro + ", cuotaDiaria=" + cuotaDiaria + ", precioHoraAnuncio=" + precioHoraAnuncio + '}';
    }
    
}
