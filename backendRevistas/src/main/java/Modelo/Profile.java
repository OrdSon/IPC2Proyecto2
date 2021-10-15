/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.sql.Blob;

/**
 *
 * @author ordson
 */
public class Profile {
    private int codigo;
    private Blob img;
    private String descripcion;
    private String hobbies;
    private int usuarioCodigo;

    public Profile(int codigo, Blob img, String descripcion, String hobbies, int usuarioCodigo) {
        this.codigo = codigo;
        this.img = img;
        this.descripcion = descripcion;
        this.hobbies = hobbies;
        this.usuarioCodigo = usuarioCodigo;
    }

    public Profile(Blob img, String descripcion, String hobbies, int usuarioCodigo) {
        this.img = img;
        this.descripcion = descripcion;
        this.hobbies = hobbies;
        this.usuarioCodigo = usuarioCodigo;
    }

    public Profile(int codigo, String descripcion, String hobbies, int usuarioCodigo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.hobbies = hobbies;
        this.usuarioCodigo = usuarioCodigo;
    }

    public Profile(String descripcion, String hobbies, int usuarioCodigo) {
        this.descripcion = descripcion;
        this.hobbies = hobbies;
        this.usuarioCodigo = usuarioCodigo;
    }

    public Profile() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public int getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public void setUsuarioCodigo(int usuarioCodigo) {
        this.usuarioCodigo = usuarioCodigo;
    }

    @Override
    public String toString() {
        return "Profile{" + "codigo=" + codigo + ", img=" + img + ", descripcion=" + descripcion + ", hobbies=" + hobbies + ", usuarioCodigo=" + usuarioCodigo + '}';
    }
    
    
}
