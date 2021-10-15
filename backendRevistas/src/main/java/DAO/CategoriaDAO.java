/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Categoria;
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
public class CategoriaDAO extends DAO{
    String INSERTAR_CATEGORIA = "INSERT INTO categoria (nombre) VALUES (?)";
    String SELECCIONAR_CATEGORIAS = "SELECT * FROM categoria";
    String SELECCIONAR_UNA_CATEGORIA = "SELECT * FROM categoria WHERE codigo = ?";
    String ELIMINAR_CATEGORIA = "DELETE * FROM categoria WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Categoria> listar() {

        ArrayList<Categoria> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_CATEGORIAS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Categoria categoria = getCategoria(resultSet);
                if (categoria != null) {
                    usuarios.add(categoria);
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
    Usa el codigo de categoria para obtener un registro
     */
    public Categoria listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_CATEGORIA);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Categoria categoria = getCategoria(resultSet);
                return categoria;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una categoria y la usa para editar un registro ya existente
     */
//    public boolean editar(Categoria categoria) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORIA);
//
//            preparedStatement.setDouble(1, categoria.getCapital());
//            preparedStatement.setInt(2, categoria.getCodigo());
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
    Usa un objeto Categoria para añadir un registro a la base de datos
     */
    public boolean añadir(Categoria categoria) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_CATEGORIA);
            preparedStatement.setString(1, categoria.getNombre());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una categoria y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_CATEGORIA);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Categoria getCategoria(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            return new Categoria(codigo, nombre);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
