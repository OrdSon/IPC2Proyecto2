/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Anunciante;
import Modelo.Anuncio;
import java.sql.Blob;
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
public class AnuncioDAO extends DAO {

    //INSERTA LA INFORMACION BÁSICA DEL ANUNCIO EN LA BASE DE DATOS
    String INSERTAR_BASE_ANUNCIO = "INSERT INTO anuncio (nombre, anunCodigocio) VALUES (?,?)";
    //INSERTA EL ARCHIVO DEL ANUNCIO A LA BASE DE DATOS
    String INSERTAR_ARCHIVO_ANUNCIO = "INSERT INTO anuncio (archivo) VALUES (?)";
    String SELECCIONAR_ANUNCIOS = "SELECT * FROM anuncio";
    String SELECCIONAR_UN_ANUNCIO = "SELECT * FROM anuncio WHERE codigo = ?";
    String SELECCIONAR_ANUNCIOS_DUEÑO = "SELECT * FROM anuncio WHERE codigo = ?";
    String ELIMINAR_ANUNCIO = "DELETE * FROM anuncio WHERE codigo = ?";
    String SELECCIONAR_ULTIMO = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Anuncio> listar() {

        ArrayList<Anuncio> anuncios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_ANUNCIOS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Anuncio anuncio  = getAnuncio(resultSet);
                if (anuncio != null) {
                    anuncios.add(anuncio);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return anuncios;
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
    Usa el codigo de anunCodigocio para obtener un registro
     */
    public Anuncio listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UN_ANUNCIO);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Anuncio anuncio  = getAnuncio(resultSet);
                return anuncio;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una anunCodigocio y la usa para editar un registro ya existente
     */
//    public boolean editar(Anunciante anunCodigocio) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAJA);
//
//            preparedStatement.setDouble(1, anunCodigocio.getCapital());
//            preparedStatement.setInt(2, anunCodigocio.getCodigo());
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
    Usa un objeto Anunciante para añadir un registro a la base de datos
     */
    public boolean añadir(Anuncio anuncio) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_BASE_ANUNCIO);
            preparedStatement.setString(1, anuncio.getNombre());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean añadirArchivo(Anuncio anuncio) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_BASE_ANUNCIO);
            preparedStatement.setString(1, anuncio.getNombre());
            preparedStatement.setInt(2, anuncio.getAnuncianteCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una anunCodigocio y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_ANUNCIO);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Anuncio getAnuncio(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            int horas = resultSet.getInt("cantidad_horas");
            Blob archivo = resultSet.getBlob("archivo");
            int anuncioCodigo = resultSet.getInt("anunCodigocio");
            return new Anuncio(codigo, nombre, horas, archivo, anuncioCodigo);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
