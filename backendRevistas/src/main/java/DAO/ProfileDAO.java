/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Profile;
import Utilidades.ImgCatcher;
import java.io.InputStream;
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

    String INSERTAR_PERFIL = "INSERT INTO perfil ( hobbies, descripcion, usuario_codigo) VALUES (?,?,?)";
    String SELECCIONAR_PERFILS = "SELECT * FROM profile";
    String SELECCIONAR_UN_PERFIL = "SELECT * FROM profile WHERE codigo = ?";
    String ELIMINAR_PERFIL = "DELETE * FROM profile WHERE codigo = ?";
    String SELECCIONAR_ULTIMO = "SELECT codigo FROM perfil ORDER BY codigo DESC LIMIT 1;";
    String SET_IMAGE = "UPDATE perfile SET foto=? WHERE codigo = ?";

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

    public boolean añadirFoto(InputStream inputStream) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SET_IMAGE);
            int codigo = ultimoCodigo();
            if (codigo>0) {
                preparedStatement.setBlob(1, inputStream);
                preparedStatement.executeUpdate();
            }
            
        } catch (SQLException ex) {

            System.out.println(ex);
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    /*
    LISTAR CODIGO
    Usa el codigo de profile para obtener un registro
     */
    public Profile listarCodigo(int codigo) {

        Profile profile = new Profile();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UN_PERFIL);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            int contador = 0;
            while (resultSet.next()) {

                profile = getProfile(resultSet);
                contador++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profile;
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
            int ultimoUsuario = usuarioDAO.ultimoCodigo();
            if (ultimoUsuario < 0) {
                System.out.println("fracaso al obtener el usuario");
                return false;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_PERFIL);
            preparedStatement.setString(1, profile.getHobbies());
            preparedStatement.setString(2, profile.getDescripcion());
            preparedStatement.setInt(3, ultimoUsuario);

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
            InputStream img = resultSet.getBlob("foto").getBinaryStream();
            String descripcion = resultSet.getString("descripcion");
            String hobbies = resultSet.getString("usuario_codigo");
            return new Profile(codigo, descripcion, hobbies);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
