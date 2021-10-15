/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Pago;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ordson
 */
public class PagoDAO extends DAO {
    
    String INSERTAR_PAGO = "INSERT INTO pago (fecha, monto, suscripcion_codigo) VALUES (?,?,?)";
    String SELECCIONAR_PAGOS = "SELECT * FROM pago";
    String SELECCIONAR_UNA_PAGO = "SELECT * FROM pago WHERE codigo = ?";
    String ELIMINAR_PAGO = "DELETE * FROM pago WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Pago> listar() {

        ArrayList<Pago> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_PAGOS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Pago pago = getPago(resultSet);
                if (pago != null) {
                    usuarios.add(pago);
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
    Usa el codigo de pago para obtener un registro
     */
    public Pago listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_PAGO);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Pago pago = getPago(resultSet);
                return pago;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una pago y la usa para editar un registro ya existente
     */
//    public boolean editar(Pago pago) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PAGO);
//
//            preparedStatement.setDouble(1, pago.getCapital());
//            preparedStatement.setInt(2, pago.getCodigo());
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
    Usa un objeto Pago para añadir un registro a la base de datos
     */
    public boolean añadir(Pago pago) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_PAGO);
            preparedStatement.setDate(1, Date.valueOf(pago.getFecha()));
            preparedStatement.setDouble(2, pago.getMonto());
            preparedStatement.setInt(3, pago.getSuscripcionCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una pago y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_PAGO);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Pago getPago(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            LocalDate fecha = resultSet.getDate("fecha").toLocalDate();
            double monto = resultSet.getDouble("monto");
            int suscripcionCodigo = resultSet.getInt("suscripcion_codigo");
            int usuarioCodigo = resultSet.getInt("usuario_codigo");
            return new Pago(codigo, fecha, monto, suscripcionCodigo, usuarioCodigo);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
