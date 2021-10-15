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
    private double procentajeCobro;
    private double cuotaDiaria;
    private double precioHoraAnuncio;

    public Setting(int codigo, double procentajeCobro, double cuotaDiaria, double precioHoraAnuncio) {
        this.codigo = codigo;
        this.procentajeCobro = procentajeCobro;
        this.cuotaDiaria = cuotaDiaria;
        this.precioHoraAnuncio = precioHoraAnuncio;
    }

    public Setting(double procentajeCobro, double cuotaDiaria, double precioHoraAnuncio) {
        this.procentajeCobro = procentajeCobro;
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

    public double getProcentajeCobro() {
        return procentajeCobro;
    }

    public void setProcentajeCobro(double procentajeCobro) {
        this.procentajeCobro = procentajeCobro;
    }

    public double getCuotaDiaria() {
        return cuotaDiaria;
    }

    public void setCuotaDiaria(double cuotaDiaria) {
        this.cuotaDiaria = cuotaDiaria;
    }

    @Override
    public String toString() {
        return "Setting{" + "codigo=" + codigo + ", procentajeCobro=" + procentajeCobro + ", cuotaDiaria=" + cuotaDiaria + ", precioHoraAnuncio=" + precioHoraAnuncio + '}';
    }
    
}
