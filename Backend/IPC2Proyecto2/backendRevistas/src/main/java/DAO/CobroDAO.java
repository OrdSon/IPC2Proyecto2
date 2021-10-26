/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Cobro;
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
public class CobroDAO extends DAO {

    String INSERTAR_COBRO_ANUNCIO = "INSERT INTO cobro (anuncio_codigo, monto, fecha) VALUES (?,?,?)";
    String INSERTAR_COBRO_CUOTA = "INSERT INTO cobro (cuota_diaria_codigo , monto, fecha) VALUES (?,?,?)";
    String INSERTAR_COBRO_PAGO = "INSERT INTO cobro (pago_codigo, monto, fecha) VALUES (?,?,?)";
    String SELECCIONAR_COBROS = "SELECT * FROM cobro";
    String SELECCIONAR_UNA_COBRO = "SELECT * FROM cobro WHERE codigo = ?";
    String ELIMINAR_COBRO = "DELETE * FROM cobro WHERE codigo = ?";
    String SELECCIONAR_ULTIMO = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Cobro> listar() {

        ArrayList<Cobro> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_COBROS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Cobro cobro = getCobro(resultSet);
                if (cobro != null) {
                    usuarios.add(cobro);
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
    Usa el codigo de cobro para obtener un registro
     */
    public Cobro listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_COBRO);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Cobro cobro = getCobro(resultSet);
                return cobro;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una cobro y la usa para editar un registro ya existente
     */
//    public boolean editar(Cobro cobro) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COBRO);
//
//            preparedStatement.setDouble(1, cobro.getCapital());
//            preparedStatement.setInt(2, cobro.getCodigo());
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
    Usa un objeto Cobro para añadir un registro a la base de datos
     */
    public boolean añadirConAnuncio(Cobro cobro) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_COBRO_ANUNCIO);
            preparedStatement.setInt(1, cobro.getAnuncioCodigo());
            preparedStatement.setDouble(2, cobro.getMonto());
            preparedStatement.setDate(3, Date.valueOf(cobro.getFecha()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean añadirConPago(Cobro cobro) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_COBRO_PAGO);
            preparedStatement.setInt(1, cobro.getPagoCodigo());
            preparedStatement.setDouble(2, cobro.getMonto());
            preparedStatement.setDate(3, Date.valueOf(cobro.getFecha()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean añadirConCuota(Cobro cobro) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_COBRO_PAGO);
            preparedStatement.setInt(1, cobro.getCuotaDiariaCodigo());
            preparedStatement.setDouble(2, cobro.getMonto());
            preparedStatement.setDate(3, Date.valueOf(cobro.getFecha()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una cobro y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_COBRO);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Cobro getCobro(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            int anuncioCodigo = resultSet.getInt("anuncio_codigo");
            int pagoCodigo = resultSet.getInt("pago_codigo");
            int cuotaCodigo = resultSet.getInt("pago_codigo");
            double monto = resultSet.getDouble("monto");
            String fecha = resultSet.getDate("fecha").toString();

            if (anuncioCodigo > 0) {
                return new Cobro(codigo, anuncioCodigo, codigo, monto, fecha);
            }
            if (pagoCodigo > 0) {
                return new Cobro(codigo, pagoCodigo, codigo, monto, fecha);
            }
            if (cuotaCodigo > 0) {
                return new Cobro(codigo, cuotaCodigo, codigo, monto, fecha);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
