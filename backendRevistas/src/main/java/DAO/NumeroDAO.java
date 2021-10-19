/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Numero;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ordson
 */
public class NumeroDAO extends DAO {

    String INSERTAR_NUMERO = "INSERT INTO numero (nombre,descripcion,fecha_publicacion,numero,revista_codigo) VALUES (?,?,?,?,?,?)";
    String INSERTAR_ARCHIVO = "UPDATE numero SET archivo = ? WHERE codigo = ?";
    String SELECCIONAR_NUMEROS = "SELECT * FROM numero";
    String SELECCIONAR_NUMEROS_REVISTA = "SELECT * FROM numero WHERE revista_codigo = ?";
    String SELECCIONAR_NUMEROS_NOMBRE = "SELECT * FROM numero WHERE nombre = ?";
    String SELECCIONAR_UNA_NUMERO = "SELECT * FROM numero WHERE codigo = ?";
    String ELIMINAR_NUMERO = "DELETE * FROM numero WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";
    
   @Override
    public ArrayList<Numero> listar() {

        ArrayList<Numero> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_NUMEROS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Numero numero = getNumero(resultSet);
                if (numero != null) {
                    usuarios.add(numero);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public int ultimoCodigo() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_ULTIMA);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                return codigo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -365;
    }

    /*
    LISTAR CODIGO
    Usa el codigo de numero para obtener un registro
     */
    public Numero listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_NUMERO);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Numero numero = getNumero(resultSet);
                return numero;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una numero y la usa para editar un registro ya existente
     */
//    public boolean editar(Numero numero) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_NUMERO);
//
//            preparedStatement.setDouble(1, numero.getCapital());
//            preparedStatement.setInt(2, numero.getCodigo());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//
//            System.out.println(ex);
//            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//
//        return true;
//    }

    /*
    AÑADIR
    Usa un objeto Numero para añadir un registro a la base de datos
     */
    public boolean añadir(Numero numero) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_NUMERO);
            preparedStatement.setString(1, numero.getNombre());
            preparedStatement.setString(2, numero.getDescripcion());
            preparedStatement.setDate(3, Date.valueOf(numero.getFechaPublicacion()));
            preparedStatement.setInt(4, numero.getNumero());
            preparedStatement.setInt(6, numero.getRevistaCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una numero y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_NUMERO);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Numero getNumero(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            String descripcion = resultSet.getString("descripcion");
            LocalDate fecha =resultSet.getDate("fecha_publicacion").toLocalDate();
            int numero = resultSet.getInt("numeros");
            int likes = resultSet.getInt("likes");
            int revistaCodigo = resultSet.getInt("revista_codigo");
            Blob archivo = resultSet.getBlob("archivo");
            return new Numero(codigo, nombre, descripcion, fecha, numero, likes, revistaCodigo, archivo);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}