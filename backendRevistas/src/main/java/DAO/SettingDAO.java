/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Setting;
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
public class SettingDAO extends DAO{
    String INSERTAR_SETTING = "INSERT INTO settings (porcentaje_cobro, cuota_diaria, precio_hora_anuncio) VALUES (?,?,?)";
    String SELECCIONAR_SETTINGS = "SELECT * FROM settings";
    String SELECCIONAR_UNA_SETTING = "SELECT * FROM settings WHERE codigo = ?";
    String ELIMINAR_SETTING = "DELETE * FROM settings WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM settings ORDER BY codigo DESC LIMIT 1;";
    String UPDATE_SETTINGS = "UPDATE settings SET porcentaje_cobro = ?, cuota_diaria = ?, precio_hora_anuncio = ? WHERE codigo = 1";

    @Override
    public ArrayList<Setting> listar() {

        ArrayList<Setting> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_SETTINGS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Setting setting = getSetting(resultSet);
                if (setting != null) {
                    usuarios.add(setting);
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
    Usa el codigo de setting para obtener un registro
     */
    public Setting listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_SETTING);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Setting setting = getSetting(resultSet);
                return setting;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una setting y la usa para editar un registro ya existente
     */
    public boolean editar(Setting setting) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SETTINGS);

            preparedStatement.setDouble(1, setting.getPorcentajeCobro());
            preparedStatement.setDouble(2, setting.getCuotaDiaria());
            preparedStatement.setDouble(3, setting.getPrecioHoraAnuncio());


            preparedStatement.executeUpdate();
        } catch (SQLException ex) {

            System.out.println(ex);
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    /*
    AÑADIR
    Usa un objeto Setting para añadir un registro a la base de datos
     */
    public boolean añadir(Setting setting) {
        try {
            if (listarCodigo(1)!=null) {
                editar(setting);
            }
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_SETTING);
            preparedStatement.setDouble(1, setting.getPorcentajeCobro());
            preparedStatement.setDouble(2, setting.getCuotaDiaria());
            preparedStatement.setDouble(3, setting.getPrecioHoraAnuncio());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una setting y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_SETTING);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Setting getSetting(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            double porcentajeCobro = resultSet.getDouble("porcentaje_cobro");
            double cuotaDiaria = resultSet.getDouble("cuota_diaria");
            double precioHoraAnuncio = resultSet.getDouble("precio_hora_anuncio");
            return new Setting(codigo, porcentajeCobro, cuotaDiaria, precioHoraAnuncio);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
