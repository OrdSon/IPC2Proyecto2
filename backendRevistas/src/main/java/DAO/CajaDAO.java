/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Caja;

/**
 *
 * @author ordson
 */
public class CajaDAO extends DAO{

    String INSERTAR_CAJA = "INSERT INTO caja (capital) VALUES (?)";
    String SELECCIONAR_CAJAS = "SELECT * FROM caja";
    String SELECCIONAR_UNA_CAJA = "SELECT * FROM caja WHERE codigo = ?";
    String ELIMINAR_CAJA = "DELETE * FROM anuncio WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Caja> listar() {

        ArrayList<Caja> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_CAJAS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Caja caja = Caja(resultSet);
                if (caja != null) {
                    usuarios.add(caja);
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
    Usa el codigo de caja para obtener un registro
     */
    public Caja listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_CAJA);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Caja caja = Caja(resultSet);
                return caja;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una caja y la usa para editar un registro ya existente
     */
//    public boolean editar(Caja caja) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAJA);
//
//            preparedStatement.setDouble(1, caja.getCapital());
//            preparedStatement.setInt(2, caja.getCodigo());
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
    Usa un objeto Caja para añadir un registro a la base de datos
     */
    public boolean añadir(Caja caja) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_CAJA);
            preparedStatement.setDouble(1, caja.getCapital());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una caja y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_CAJA);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Caja Caja(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            double capital = resultSet.getDouble("capital");
            return new Caja(codigo, capital);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
