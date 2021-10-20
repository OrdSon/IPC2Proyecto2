/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Profile;
import Utilidades.ImgCatcher;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
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
public class ProfileDAO extends DAO {

    ImgCatcher imgCatcher = new ImgCatcher();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    String INSERTAR_PERFIL = "INSERT INTO perfil (foto, hobbies, descripcion, usuario_codigo) VALUES (?,?,?,?)";
    String SELECCIONAR_PERFILS = "SELECT * FROM perfil";
    String SELECCIONAR_UN_PERFIL = "SELECT * FROM perfil WHERE usuario_codigo = ?";
    String ELIMINAR_PERFIL = "DELETE * FROM profile WHERE codigo = ?";
    String SELECCIONAR_ULTIMO = "SELECT codigo FROM perfil ORDER BY codigo DESC LIMIT 1;";
    String SET_IMAGE = "UPDATE perfil SET foto=? WHERE codigo = ?";

    @Override
    public ArrayList<Profile> listar() {

        ArrayList<Profile> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_PERFILS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Profile profile = getProfile(resultSet);
                if (profile != null) {
                    usuarios.add(profile);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public int ultimoCodigo() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_ULTIMO);
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
    Usa el codigo de profile para obtener un registro
     */
    public Profile listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UN_PERFIL);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Profile profile = getProfile(resultSet);
                return profile;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una profile y la usa para editar un registro ya existente
     */
//    public boolean editar(Profile profile) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAJA);
//
//            preparedStatement.setDouble(1, profile.getCapital());
//            preparedStatement.setInt(2, profile.getCodigo());
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
    Usa un objeto Profile para añadir un registro a la base de datos
     */
    public boolean añadir(Profile profile) {
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_PERFIL);
            byte[] decodedByte = profile.getImg().getBytes();
            InputStream imagen = new ByteArrayInputStream(decodedByte);
            preparedStatement.setBlob(1, imagen);
            preparedStatement.setString(2, profile.getHobbies());
            preparedStatement.setString(3, profile.getDescripcion());
            preparedStatement.setInt(4, profile.getUsuarioCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una profile y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_PERFIL);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Profile getProfile(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            Blob foto = resultSet.getBlob("foto");
            String hobbies  = resultSet.getString("hobbies");
            String descripcion = resultSet.getString("descripcion");
            int usuarioCodigo = resultSet.getInt("usuario_codigo");
            
            InputStream inputStream = foto.getBinaryStream();
            byte[] bytes = inputStream.readAllBytes();
            String imagenBase64 = new String(bytes);
            System.out.println(imagenBase64);
            return new Profile(codigo, imagenBase64, descripcion, hobbies, usuarioCodigo);
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
