/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Cobro;
import Modelo.Pago;
import Modelo.Suscripcion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ordson
 */
public class SuscripcionDAO extends DAO {

    String INSERTAR_SUSCRIPCION = "INSERT INTO suscripcion (usuario_codigo, revista_codigo, fecha, estado, pagos, proximoPago) VALUES (?,?,?,?,?,?)";
    String SELECCIONAR_SUSCRIPCIONS = "SELECT * FROM suscripcion WHERE estado = ?";
    String SELECCIONAR_UNA_SUSCRIPCION = "SELECT * FROM suscripcion WHERE codigo = ?";
    String SELECCIONAR_POR_CODIGOSS = "SELECT * FROM suscripcion WHERE usuario_codigo = ? AND revista_codigo = ?";
    String ELIMINAR_SUSCRIPCION = "DELETE * FROM suscripcion WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM suscripcion ORDER BY codigo DESC LIMIT 1;";
    String DESACTIVAR_SUSCRIPCION = "UPDATE suscripcion SET estado = ? WHERE codigo = ?";

    @Override
    public List<Suscripcion> listar() {

        List<Suscripcion> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_SUSCRIPCIONS);
            preparedStatement.setString(1, "true");
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
    public Suscripcion listarCodigoUsuario(int usuarioCodigo, int revistaCodigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_POR_CODIGOSS);
            preparedStatement.setInt(1, usuarioCodigo);
            preparedStatement.setInt(2, revistaCodigo);
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
            preparedStatement.setString(4, suscripcion.getEstado());
            preparedStatement.setInt(5, suscripcion.getPagos());
            preparedStatement.setDate(6, Date.valueOf(suscripcion.getProximoPago()));
            
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
            int codigo = resultSet.getInt("codigo");
            int usuarioCodigo = resultSet.getInt("usuario_codigo");
            int revistaCodigo = resultSet.getInt("revista_codigo");
            String fecha = resultSet.getDate("fecha").toString();
            String estado = resultSet.getString("estado");
            int pagos = resultSet.getInt("pagos");
            String proximoPago = resultSet.getDate("proximoPago").toString();
            
            return new Suscripcion(codigo, usuarioCodigo, revistaCodigo, fecha, estado, pagos, proximoPago);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void suscribirse(Suscripcion suscripcion){
        
        Suscripcion temporal = listarCodigoUsuario(suscripcion.getUsuarioCodigo(), suscripcion.getRevistaCodigo());
        RevistaDAO revistaDAO = new RevistaDAO();
        double precio = revistaDAO.listarCodigo(suscripcion.getRevistaCodigo()).getPrecio();
        
        if (temporal == null) {
        suscripcion.setProximoPago(proximoMes(suscripcion));
        suscripcion.setEstado("true");
        suscripcion.setPagos(suscripcion.getPagos()+1);
        añadir(suscripcion);
        Suscripcion nueva = listarCodigo(ultimoCodigo());
        generarPago(nueva, precio);
        return;
        }
        generarPago(temporal, precio);
        
    }
    public void desactivar(Suscripcion suscripcion){
         try {
            PreparedStatement preparedStatement = connection.prepareStatement(DESACTIVAR_SUSCRIPCION);
            Suscripcion temporal = listarCodigoUsuario(suscripcion.getUsuarioCodigo(), suscripcion.getRevistaCodigo());
            preparedStatement.setString(1, "false");
            preparedStatement.setInt(2, temporal.getCodigo());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {

            System.out.println(ex);
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private boolean generarPago(Suscripcion suscripcion, double precio){
        try {
            SettingDAO settingDAO = new SettingDAO();
        PagoDAO pagoDAO = new PagoDAO();
        CobroDAO cobroDAO = new CobroDAO();
        double porcentaje = settingDAO.listarCodigo(1).getPorcentajeCobro();
        double pagoAEditor = (precio - (precio*(porcentaje/100)));
        double pagoAdmin = (precio*(porcentaje/100));
        Pago pago = new Pago(suscripcion.getFecha(),pagoAEditor,suscripcion.getCodigo(),suscripcion.getUsuarioCodigo());
        pagoDAO.añadir(pago);
        Pago nuevo = pagoDAO.listarCodigo(pagoDAO.ultimoCodigo());
        Cobro cobro = new Cobro(nuevo.getCodigo(),2, pagoAdmin,suscripcion.getFecha());
        cobroDAO.añadirConPago(cobro);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    private String proximoMes(Suscripcion suscripcion){
        Date fecha = Date.valueOf(suscripcion.getFecha());
        LocalDate temporal = fecha.toLocalDate();
        LocalDate fechaPlus = temporal.plusMonths(1);
        String nuevaFecha = fechaPlus.toString();
        return nuevaFecha;
    }
}
