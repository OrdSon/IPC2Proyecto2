/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Anunciante;
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
public class AnuncianteDAO extends DAO{
    String INSERTAR_ANUNCIATE = "INSERT INTO anunciante (nombre) VALUES (?)";
    String SELECCIONAR_ANUNCIANTES = "SELECT * FROM anunciante";
    String SELECCRIONAR_UN_ANUNCIATE = "SELECT * FROM anunciante WHERE codigo = ?";
    String ELIMINAR_ANUNCIATE = "DELETE * FROM anunciante WHERE codigo = ?";
    String SELECCIONAR_ULTIMO = "SELECT codigo FROM anunciante ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Anunciante> listar() {

        ArrayList<Anunciante> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_ANUNCIANTES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Anunciante anunciante = getAnunciante(resultSet);
                if (anunciante != null) {
                    usuarios.add(anunciante);
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
    Usa el codigo de anunciante para obtener un registro
     */
    public Anunciante listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCRIONAR_UN_ANUNCIATE);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Anunciante anunciante = getAnunciante(resultSet);
                return anunciante;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una anunciante y la usa para editar un registro ya existente
     */
//    public boolean editar(Anunciante anunciante) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAJA);
//
//            preparedStatement.setDouble(1, anunciante.getCapital());
//            preparedStatement.setInt(2, anunciante.getCodigo());
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
    Usa un objeto Anunciante para añadir un registro a la base de datos
     */
    public boolean añadir(Anunciante anunciante) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_ANUNCIATE);
            preparedStatement.setString(1, anunciante.getNombre());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una anunciante y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_ANUNCIATE);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Anunciante getAnunciante(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            return new Anunciante(codigo, nombre);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
