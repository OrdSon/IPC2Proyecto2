/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Referencia;
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
public class ReferenciaDAO extends DAO{
      String INSERTAR_REFERENCIA = "INSERT INTO referencia (numero_codigo, tag_codigo) VALUES (?,?)";
    String SELECCIONAR_REFERENCIAS = "SELECT * FROM referencia";
    String SELECCIONAR_UNA_REFERENCIA = "SELECT * FROM referencia WHERE codigo = ?";
    String ELIMINAR_REFERENCIA = "DELETE * FROM referencia WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Referencia> listar() {

        ArrayList<Referencia> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_REFERENCIAS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Referencia referencia = getReferencia(resultSet);
                if (referencia != null) {
                    usuarios.add(referencia);
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
    Usa el codigo de referencia para obtener un registro
     */
    public Referencia listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_REFERENCIA);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Referencia referencia = getReferencia(resultSet);
                return referencia;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una referencia y la usa para editar un registro ya existente
     */
//    public boolean editar(Referencia referencia) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REFERENCIA);
//
//            preparedStatement.setDouble(1, referencia.getCapital());
//            preparedStatement.setInt(2, referencia.getCodigo());
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
    Usa un objeto Referencia para añadir un registro a la base de datos
     */
    public boolean añadir(Referencia referencia) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_REFERENCIA);
            preparedStatement.setInt(1, referencia.getNumeroCodigo());
            preparedStatement.setInt(2, referencia.getTagCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una referencia y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_REFERENCIA);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Referencia getReferencia(ResultSet resultSet) {
        try {
            int numeroCodigo = resultSet.getInt("numero_codigo");
            int tagCodigo = resultSet.getInt("tag_codigo");
            return new Referencia(numeroCodigo, tagCodigo);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
