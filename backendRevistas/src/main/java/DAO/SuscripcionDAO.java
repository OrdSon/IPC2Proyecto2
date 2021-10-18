/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Suscripcion;
import java.sql.Date;
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
public class SuscripcionDAO extends DAO {

    String INSERTAR_SUSCRIPCION = "INSERT INTO suscripcion (usuario_codigo, revista_codigo, fecha) VALUES (?,?,?)";
    String SELECCIONAR_SUSCRIPCIONS = "SELECT * FROM suscripcion";
    String SELECCIONAR_UNA_SUSCRIPCION = "SELECT * FROM suscripcion WHERE codigo = ?";
    String ELIMINAR_SUSCRIPCION = "DELETE * FROM suscripcion WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Suscripcion> listar() {

        ArrayList<Suscripcion> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_SUSCRIPCIONS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Suscripcion suscripcion = getSuscripcion(resultSet);
                if (suscripcion != null) {
                    usuarios.add(suscripcion);
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
    Usa el codigo de suscripcion para obtener un registro
     */
    public Suscripcion listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_SUSCRIPCION);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Suscripcion suscripcion = getSuscripcion(resultSet);
                return suscripcion;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una suscripcion y la usa para editar un registro ya existente
     */
//    public boolean editar(Suscripcion suscripcion) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SUSCRIPCION);
//
//            preparedStatement.setDouble(1, suscripcion.getCapital());
//            preparedStatement.setInt(2, suscripcion.getCodigo());
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
    Usa un objeto Suscripcion para añadir un registro a la base de datos
     */
    public boolean añadir(Suscripcion suscripcion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_SUSCRIPCION);
            preparedStatement.setInt(1, suscripcion.getUsuarioCodigo());
            preparedStatement.setInt(2, suscripcion.getRevistaCodigo());
            preparedStatement.setDate(3, Date.valueOf(suscripcion.getFecha()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una suscripcion y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_SUSCRIPCION);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Suscripcion getSuscripcion(ResultSet resultSet) {
        try {
            int usuarioCodigo = resultSet.getInt("usuario_codigo");
            int revistaCodigo = resultSet.getInt("revista_codigo");
            String fecha = resultSet.getDate("fecha").toString();
            return new Suscripcion(usuarioCodigo, revistaCodigo, fecha);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
