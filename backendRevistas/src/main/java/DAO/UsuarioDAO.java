/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.LoginCheck;
import Modelo.Usuario;
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
public class UsuarioDAO extends DAO{

    String INSERTAR_USUARIO = "INSERT INTO usuario (nombre, email, nombre_usuario, tipo, contraseña) VALUES (?,?,?,?,?)";
    String SELECCIONAR_USUARIOS = "SELECT * FROM usuario";
    String SELECCIONAR_UN_USUARIO = "SELECT * FROM usuario WHERE codigo = ?";
    String ELIMINAR_USUARIO = "DELETE * FROM usuario WHERE codigo = ?";
    String SELECCIONAR_ULTIMO = "SELECT codigo FROM usuario ORDER BY codigo DESC LIMIT 1";
    String SELECCIONAR_LOGIN = "SELECT * FROM usuario WHERE email = ? and contraseña = ? ORDER BY codigo LIMIT 1";
    String SELECCIONAR_USUARIO_EMAIL = "SELECT * FROM usuario WHERE email = ?";

    public UsuarioDAO(){
        super();
    }
    /*LISTAR
    Crea una lista de usuarios y la exporta para su uso
     */
    @Override
    public ArrayList<Usuario> listar() {
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_USUARIOS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Usuario usuario = getUsuario(resultSet);
                if (usuario != null) {
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    
    public int ultimoCodigo(){
        
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
    Usa el codigo de usuario para obtener un registro
     */
    public Usuario listarCodigo(int codigo) {

        Usuario usuario = new Usuario();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UN_USUARIO);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            int contador = 0;
            while (resultSet.next()) {

                usuario = getUsuario(resultSet);
                contador++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    public Usuario loginCheck(LoginCheck loginCheck) {

        Usuario usuario = new Usuario();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_LOGIN);
            preparedStatement.setString(1, loginCheck.getEmail());
            preparedStatement.setString(2, loginCheck.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            int contador = 0;
            while (resultSet.next()) {

                usuario = getUsuario(resultSet);
                if (usuario != null) {
                    return usuario;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    /*
    EDITAR
    Recibe una usuario y la usa para editar un registro ya existente
     */
//    public boolean editar(Usuario usuario) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAJA);
//
//            preparedStatement.setDouble(1, usuario.getCapital());
//            preparedStatement.setInt(2, usuario.getCodigo());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//
//            System.out.println(ex);
//            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//
//        return true;
//    }

    /*
    AÑADIR
    Usa un objeto Usuario para añadir un registro a la base de datos
     */
    public boolean añadir(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_USUARIO);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getNickName());
            preparedStatement.setInt(4, usuario.getTipo());
            preparedStatement.setString(5, usuario.getPassword());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una usuario y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_USUARIO);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            try {
                connection.rollback();
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return true;
    }

    private Usuario getUsuario(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            String email = resultSet.getString("email");
            String nickName = resultSet.getString("nombre_usuario");
            int tipo = resultSet.getInt("tipo");
            String contraseña = resultSet.getString("contraseña");
            return new Usuario(codigo, nombre, email, nickName, tipo, contraseña);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
