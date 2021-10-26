/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Cuota;
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
public class CuotaDiariaDAO extends DAO{
    String INSERTAR_CUOTA = "INSERT INTO cuota (monto, fecha, revista_codigo) VALUES (?,?,?)";
    String SELECCIONAR_CUOTAS = "SELECT * FROM cuota";
    String SELECCIONAR_UNA_CUOTA = "SELECT * FROM cuota WHERE codigo = ?";
    String ELIMINAR_CUOTA = "DELETE * FROM cuota WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";
    
    @Override
    public ArrayList<Cuota> listar() {

        ArrayList<Cuota> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_CUOTAS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Cuota cuota = getCuota(resultSet);
                if (cuota != null) {
                    usuarios.add(cuota);
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
    Usa el codigo de cuota para obtener un registro
     */
    public Cuota listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_CUOTA);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Cuota cuota = getCuota(resultSet);
                return cuota;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una cuota y la usa para editar un registro ya existente
     */
//    public boolean editar(Cuota cuota) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUOTA);
//
//            preparedStatement.setDouble(1, cuota.getCapital());
//            preparedStatement.setInt(2, cuota.getCodigo());
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
    Usa un objeto Cuota para añadir un registro a la base de datos
     */
    public boolean añadir(Cuota cuota) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_CUOTA);
            preparedStatement.setDouble(1, cuota.getMonto());
            preparedStatement.setDate(2, Date.valueOf(cuota.getFecha()));
            preparedStatement.setInt(3, cuota.getRevistaCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una cuota y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_CUOTA);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Cuota getCuota(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            double monto = resultSet.getDouble("monto");
            LocalDate fecha = resultSet.getDate("fecha").toLocalDate();
            int revistaCodigo = resultSet.getInt("revista_codigo");
            return new Cuota(codigo, monto, fecha, revistaCodigo);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
