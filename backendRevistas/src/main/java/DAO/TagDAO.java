/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Tag;
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
public class TagDAO extends DAO{
      String INSERTAR_TAG = "INSERT INTO tag (nombre) VALUES (?)";
    String SELECCIONAR_TAGS = "SELECT * FROM tag";
    String SELECCIONAR_UNA_TAG = "SELECT * FROM tag WHERE codigo = ?";
    String ELIMINAR_TAG = "DELETE * FROM tag WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Tag> listar() {

        ArrayList<Tag> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_TAGS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Tag tag = getTag(resultSet);
                if (tag != null) {
                    usuarios.add(tag);
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
    Usa el codigo de tag para obtener un registro
     */
    public Tag listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_TAG);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Tag tag = getTag(resultSet);
                return tag;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una tag y la usa para editar un registro ya existente
     */
//    public boolean editar(Tag tag) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TAG);
//
//            preparedStatement.setDouble(1, tag.getCapital());
//            preparedStatement.setInt(2, tag.getCodigo());
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
    Usa un objeto Tag para añadir un registro a la base de datos
     */
    public boolean añadir(Tag tag) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_TAG);
            preparedStatement.setString(1, tag.getNombre());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una tag y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_TAG);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    private Tag getTag(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            return new Tag(codigo, nombre);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
