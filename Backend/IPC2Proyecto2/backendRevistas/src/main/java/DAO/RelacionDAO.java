/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Relacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ordson
 */
public class RelacionDAO extends DAO{
      String INSERTAR_RELACION = "INSERT INTO relacion (codigo_revista, codigo_categoria) VALUES (?,?)";
    String SELECCIONAR_RELACIONS = "SELECT * FROM relacion";
    String SELECCIONAR_UNA_RELACION = "SELECT * FROM relacion WHERE codigo = ?";
    String ELIMINAR_RELACION = "DELETE * FROM relacion WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Relacion> listar() {

        ArrayList<Relacion> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_RELACIONS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Relacion relacion = getRelacion(resultSet);
                if (relacion != null) {
                    usuarios.add(relacion);
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
    Usa el codigo de relacion para obtener un registro
     */
    public Relacion listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_RELACION);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Relacion relacion = getRelacion(resultSet);
                return relacion;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una relacion y la usa para editar un registro ya existente
     */
//    public boolean editar(Relacion relacion) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RELACION);
//
//            preparedStatement.setDouble(1, relacion.getCapital());
//            preparedStatement.setInt(2, relacion.getCodigo());
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
    Usa un objeto Relacion para añadir un registro a la base de datos
     */
    public boolean añadir(Relacion relacion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_RELACION);
            preparedStatement.setInt(1, relacion.getCodigoRevista());
            preparedStatement.setInt(2, relacion.getCodigoRevista());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una relacion y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_RELACION);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    private Relacion getRelacion(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            int codigoRevista = resultSet.getInt("codigo_revista");
            int codigoCategoria = resultSet.getInt("codigo_categoria");
            return new Relacion(codigo,codigoRevista, codigoCategoria);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
