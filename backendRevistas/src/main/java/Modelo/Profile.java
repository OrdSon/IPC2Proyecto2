/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.io.InputStream;

/**
 *
 * @author ordson
 */
public class Profile {
    private int codigo;
    private String descripcion;
    private String hobbies;

    public Profile(int codigo, String descripcion, String hobbies) {
        this.codigo = codigo;
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
    
    @Override
    public String toString(){
        return this.codigo+" "+this.descripcion+" "+this.hobbies;
    }
    
    
}
