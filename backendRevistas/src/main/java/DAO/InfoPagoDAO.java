/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.InfoPago;
import java.io.InputStream;
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
public class InfoPagoDAO extends DAO {

    String INSERTAR_INFO_PAGO = "INSERT INTO info_compra(tarjeta, cuenta_bancaria, vencimiento, usuario_codigo) VALUES (?,?,?,?)";
    String SELECCIONAR_INFO_PAGOS = "SELECT * FROM info_compra";
    String SELECCIONAR_UN_INFO_PAGO = "SELECT * FROM info_compra WHERE codigo = ?";
    String SELECCIONAR_UN_INFO_PAGO_USUARIO = "SELECT * FROM info_compra WHERE usuario_codigo = ?";
    String ELIMINAR_INFO_PAGO = "DELETE * FROM info_pago WHERE codigo = ?";
    String SELECCIONAR_ULTIMO = "SELECT codigo FROM info_pago ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<InfoPago> listar() {

        ArrayList<InfoPago> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_INFO_PAGOS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                InfoPago infoPago = getInfoPago(resultSet);
                if (infoPago != null) {
                    usuarios.add(infoPago);
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
    Usa el codigo de infoPago para obtener un registro
     */
    public InfoPago listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UN_INFO_PAGO);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                InfoPago infoPago = getInfoPago(resultSet);
                return infoPago;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una infoPago y la usa para editar un registro ya existente
     */
//    public boolean editar(InfoPago infoPago) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAJA);
//
//            preparedStatement.setDouble(1, infoPago.getCapital());
//            preparedStatement.setInt(2, infoPago.getCodigo());
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
    Usa un objeto InfoPago para añadir un registro a la base de datos
     */
    public boolean añadir(InfoPago infoPago, int usuarioCodigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_INFO_PAGO);
            preparedStatement.setString(1 , infoPago.getTarjeta());
            preparedStatement.setString(1 , infoPago.getCuenta_bancaria());
            preparedStatement.setDate(1 , Date.valueOf(infoPago.getVencimiento()));
            preparedStatement.setInt(1 , infoPago.getUsuario_codigo());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una infoPago y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_INFO_PAGO);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private InfoPago getInfoPago(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            String tarjeta = resultSet.getString("tarjeta");
            String cuenta_bancaria = resultSet.getString("cuenta");
            LocalDate vencimiento = resultSet.getDate("vencimiento").toLocalDate();
            int usuario_codigo = resultSet.getInt("usuario_codigo");
            return new InfoPago(codigo, tarjeta, cuenta_bancaria, vencimiento, usuario_codigo);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
