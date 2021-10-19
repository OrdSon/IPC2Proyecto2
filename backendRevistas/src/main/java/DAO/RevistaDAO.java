/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Revista;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ordson
 */
public class RevistaDAO extends DAO {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    String INSERTAR_REVISTA = "INSERT INTO revista (nombre, fecha, precio, descripcion, autor) VALUES (?,?,?,?,?)";
    String SELECCIONAR_REVISTAS = "SELECT * FROM revista";
    String SELECCIONAR_UN_REVISTA = "SELECT * FROM revista WHERE codigo LIKE ?";
    String SELECCIONAR_REVISTA_NOMBRE = "SELECT * FROM revista WHERE nombre  LIKE ?";
    String ELIMINAR_REVISTA = "DELETE FROM revista WHERE codigo = ?";
    String SELECCIONAR_ULTIMO = "SELECT codigo FROM revista ORDER BY codigo DESC LIMIT 1;";
    String SELECCIONAR_POR_AUTOR = "SELECT * FROM revista WHERE autor = ? ORDER BY codigo DESC";
    String UPDATE_REVISTA = "UPDATE revista SET nombre = ?, descripcion = ?, precio = ? WHERE codigo = ?";

    @Override
    public List<Revista> listar() {

        ArrayList<Revista> revistas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_REVISTAS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Revista revista = getRevista(resultSet);
                if (revista != null) {
                    revistas.add(revista);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return revistas;
    }

    public List<Revista> listarPorNombre(String cadena) {
        ArrayList<Revista> revistas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_REVISTAS);
            preparedStatement.setString(1, "%" + cadena + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Revista revista = getRevista(resultSet);
                if (revista != null) {
                    revistas.add(revista);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return revistas;
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
    Usa el codigo de revista para obtener un registro
     */
    public Revista listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UN_REVISTA);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Revista revista = getRevista(resultSet);
                return revista;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Revista> listarPorAutor(Revista revista) {

        ArrayList<Revista> revistas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_POR_AUTOR);
            preparedStatement.setInt(1, revista.getCodigo());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Revista temporal = getRevista(resultSet);
                revistas.add(temporal);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return revistas;
    }

    /*
    EDITAR
    Recibe una revista y la usa para editar un registro ya existente
     */
    public boolean editar(Revista revista) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REVISTA);

            preparedStatement.setString(1, revista.getNombre());
            preparedStatement.setString(2, revista.getDescripcion());
            preparedStatement.setDouble(3, revista.getPrecio());
            preparedStatement.setInt(4, revista.getCodigo());

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
    Usa un objeto Revista para añadir un registro a la base de datos
     */
    public boolean añadir(Revista revista) {
        try {
            Date date = Date.valueOf(revista.getFecha());
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_REVISTA);
            preparedStatement.setString(1, revista.getNombre());
            preparedStatement.setDate(2, date);
            preparedStatement.setDouble(3, revista.getPrecio());
            preparedStatement.setString(4, revista.getDescripcion());
            preparedStatement.setInt(5, revista.getAutor());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una revista y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_REVISTA);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Revista getRevista(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            String descripcion = resultSet.getString("descripcion");
            Date fecha = resultSet.getDate("fecha");
            int autor = resultSet.getInt("autor");
            double precio = resultSet.getDouble("precio");

            return new Revista(codigo, nombre, descripcion, fecha.toString(), autor, precio);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
