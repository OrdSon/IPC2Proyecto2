/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Anuncio;
import Modelo.Cobro;
import Modelo.Setting;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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
public class AnuncioDAO extends DAO {

    //INSERTA LA INFORMACION BÁSICA DEL ANUNCIO EN LA BASE DE DATOS
    String INSERTAR_BASE_ANUNCIO = "INSERT INTO anuncio (nombre, cantidad_horas, archivo, anunciante_codigo,fecha,final) VALUES (?,?,?,?,?,?)";
    //INSERTA EL ARCHIVO DEL ANUNCIO A LA BASE DE DATOS
    String SELECCIONAR_ANUNCIOS = "SELECT * FROM anuncio";
    String SELECCIONAR_UN_ANUNCIO = "SELECT * FROM anuncio WHERE codigo = ?";
    String SELECCIONAR_ANUNCIOS_DUEÑO = "SELECT * FROM anuncio WHERE codigo = ?";
    String ELIMINAR_ANUNCIO = "DELETE * FROM anuncio WHERE codigo = ?";
    String SELECCIONAR_ULTIMO = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";
    String GET_RANDOM = "SELECT * FROM anuncio WHERE fecha <= NOW() AND final >= NOW() ORDER BY RAND() LIMIT 1;";
    String SUMAR_VECES = "UPDATE anuncio SET veces = ? WHERE codigo = ?";

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
    
    public Anuncio listarRandom() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_RANDOM);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Anuncio anuncio  = getAnuncio(resultSet);
                sumarVeces(anuncio);
                System.out.println(anuncio.toString());
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
    public boolean sumarVeces(Anuncio anuncio) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SUMAR_VECES);

            preparedStatement.setInt(1, anuncio.getVeces()+1);
            preparedStatement.setInt(2, anuncio.getCodigo());

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
    Usa un objeto Anunciante para añadir un registro a la base de datos
     */
    public boolean añadir(Anuncio anuncio) {
        try {
            //nombre, cantidad_horas, archivo, anunciante_codigo,fecha,final
            byte[] decodedByte = anuncio.getArchivo().getBytes();
            InputStream imagen = new ByteArrayInputStream(decodedByte);
            
            
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_BASE_ANUNCIO);
            preparedStatement.setString(1, anuncio.getNombre());
            preparedStatement.setInt(2, anuncio.getHoras());
            preparedStatement.setBlob(3, imagen);
            preparedStatement.setInt(4, anuncio.getAnuncianteCodigo());
            preparedStatement.setDate(5, Date.valueOf(anuncio.getFecha()));
            
            LocalDate temporal = Date.valueOf(anuncio.getFecha()).toLocalDate();
            LocalDate finale = temporal.plusDays(anuncio.getHoras());
            
            preparedStatement.setDate(6, Date.valueOf(finale));
            
            preparedStatement.executeUpdate();
            
            SettingDAO settingDAO = new SettingDAO();
            Setting setting = settingDAO.listarCodigo(1);
            CobroDAO cobroDAO = new CobroDAO();
            cobroDAO.añadirConAnuncio(new Cobro(ultimoCodigo(),1,(setting.getPrecioHoraAnuncio()*anuncio.getHoras()),anuncio.getFecha()));
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
            int anuncioCodigo = resultSet.getInt("anunciante_codigo");
            int veces = resultSet.getInt("veces");
            String fecha = resultSet.getDate("fecha").toString();
            String finale = resultSet.getDate("final").toString();
            InputStream inputStream = archivo.getBinaryStream();
            byte[] bytes = inputStream.readAllBytes();
            String imagenBase64 = new String(bytes);
            return new Anuncio(codigo, nombre, horas, imagenBase64, fecha, anuncioCodigo, veces, finale);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AnuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
