/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Publico;
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
public class PublicoDAO extends DAO{
      String INSERTAR_CATEGORIA = "INSERT INTO publico (anuncio_codigo, tag_codigo) VALUES (?,?)";
    String SELECCIONAR_CATEGORIAS = "SELECT * FROM publico";
    String SELECCIONAR_UNA_CATEGORIA = "SELECT * FROM publico WHERE anuncio_codigo = ? AND tag_codigo = ?";
    String ELIMINAR_CATEGORIA = "DELETE * FROM publico WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Publico> listar() {

        ArrayList<Publico> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_CATEGORIAS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Publico publico = getPublico(resultSet);
                if (publico != null) {
                    usuarios.add(publico);
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
    Usa el codigo de publico para obtener un registro
     */
    public Publico listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_CATEGORIA);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Publico publico = getPublico(resultSet);
                return publico;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una publico y la usa para editar un registro ya existente
     */
//    public boolean editar(Publico publico) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORIA);
//
//            preparedStatement.setDouble(1, publico.getCapital());
//            preparedStatement.setInt(2, publico.getCodigo());
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
    Usa un objeto Publico para añadir un registro a la base de datos
     */
    public boolean añadir(Publico publico) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_CATEGORIA);
            preparedStatement.setInt(1, publico.getAnuncioCodigo());
            preparedStatement.setInt(2, publico.getTagCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una publico y lo usa para encontrar al objetivo
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

    private Publico getPublico(ResultSet resultSet) {
        try {
            int anuncioCodigo = resultSet.getInt("anuncio_codigo");
            int tagCodigo = resultSet.getInt("tag_codigo");
            return new Publico(anuncioCodigo, tagCodigo);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
