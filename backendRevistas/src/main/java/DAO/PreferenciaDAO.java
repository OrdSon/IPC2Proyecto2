/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Preferencia;
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
public class PreferenciaDAO extends DAO{
      String INSERTAR_PREFERENCIA = "INSERT INTO preferencia (usuario_codigo, categoria_codigo) VALUES (?,?)";
    String SELECCIONAR_PREFERENCIAS = "SELECT * FROM preferencia";
    String SELECCIONAR_UNA_PREFERENCIA = "SELECT * FROM preferencia WHERE codigo = ?";
    String SELECCIONAR_POR_CATEGORIA = "SELECT * FROM preferencia WHERE categoria_codigo = ?";
    String ELIMINAR_PREFERENCIA = "DELETE * FROM preferencia WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Preferencia> listar() {

        ArrayList<Preferencia> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_PREFERENCIAS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Preferencia preferencia = getPreferencia(resultSet);
                if (preferencia != null) {
                    usuarios.add(preferencia);
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
    Usa el codigo de preferencia para obtener un registro
     */
    public Preferencia listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_PREFERENCIA);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Preferencia preferencia = getPreferencia(resultSet);
                return preferencia;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una preferencia y la usa para editar un registro ya existente
     */
//    public boolean editar(Preferencia preferencia) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PREFERENCIA);
//
//            preparedStatement.setDouble(1, preferencia.getCapital());
//            preparedStatement.setInt(2, preferencia.getCodigo());
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
    Usa un objeto Preferencia para añadir un registro a la base de datos
     */
    public boolean añadir(Preferencia preferencia) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_PREFERENCIA);
            preparedStatement.setInt(1, preferencia.getUsuarioCodigo());
            preparedStatement.setInt(2, preferencia.getCategoriaCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una preferencia y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_PREFERENCIA);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Preferencia getPreferencia(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            int usuarioCodigo = resultSet.getInt("usuario_codigo");
            int categoriaCodigo = resultSet.getInt("categoria_codigo");
            return new Preferencia(codigo,usuarioCodigo, categoriaCodigo);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
