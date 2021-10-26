/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utilidades.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ordson
 */
public abstract class DAO {
    Connection connection;
    Conexion conexion;
    public DAO() {
        this.conexion = new Conexion();
        this.connection = Conexion.getConnection();
    }
    
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    
    public List listar() {
        return new ArrayList();
    }
    
}
