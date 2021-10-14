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

    public Profile(int codigo, Blob img, String descripcion, String hobbies) {
        this.codigo = codigo;
        this.img = img;
        this.descripcion = descripcion;
        this.hobbies = hobbies;
    }

    public Profile(Blob img, String descripcion, String hobbies) {
        this.img = img;
        this.descripcion = descripcion;
        this.hobbies = hobbies;
    }

    public Profile(String descripcion, String hobbies) {
        this.descripcion = descripcion;
        this.hobbies = hobbies;
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

    
    
}
