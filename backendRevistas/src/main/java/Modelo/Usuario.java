/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ordson
 */
public class Usuario {
    int codigo;
    String nombre;
    String email;
    String nombre_usuario;
    int tipo;
    String password;

    public Usuario(int codigo, String nombre, String email, String nickName, int tipo, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
        this.nombre_usuario = nickName;
        this.tipo = tipo;
        this.password = password;
    }

    public Usuario(String nombre, String email, String nickName, int tipo, String password) {
        this.nombre = nombre;
        this.email = email;
        this.nombre_usuario = nickName;
        this.tipo = tipo;
        this.password = password;
    }

    public Usuario() {
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nombre_usuario;
    }

    public void setNickName(String nickName) {
        this.nombre_usuario = nickName;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString(){
        return codigo+""+nombre+" "+email+" "+nombre_usuario+" "+password+" "+tipo;
    }
    
    
}
