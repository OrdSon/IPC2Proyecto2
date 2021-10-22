/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Numero;
import Modelo.Preview;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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
public class ListaDAO extends DAO {

    String SELECT_LIST = "SELECT n.codigo, n.nombre, n.descripcion, n.fecha_publicacion, n. numero, n.likes, \n"
            + "n.revista_codigo, n.archivo, r.nombre as revista, r.precio , u.nombre as autor, u.email\n"
            + "FROM numero as n INNER JOIN revista as r ON n.revista_codigo = r.codigo INNER JOIN\n"
            + " usuario as u ON r.autor = u.codigo WHERE n.fecha_publicacion <= NOW() AND r.fecha <= NOW();";

    @Override
    public List<Preview> listar() {

        List<Preview> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Preview Preview = getPreview(resultSet);
                if (Preview != null) {
                    usuarios.add(Preview);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    private Preview getPreview(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            String descripcion = resultSet.getString("descripcion");
            Date fecha = resultSet.getDate("fecha_publicacion");
            int numero = resultSet.getInt("numero");
            int likes = resultSet.getInt("likes");
            int revistaCodigo = resultSet.getInt("revista_codigo");
            Blob file = resultSet.getBlob("archivo");
            InputStream inputStream = file.getBinaryStream();
            byte[] bytes = inputStream.readAllBytes();
            String archivo = new String(bytes);
            String revista = resultSet.getString("revista");
            double precio = resultSet.getDouble("precio");
            String autor = resultSet.getString("autor");
            String email = resultSet.getString("email");

            return new Preview(codigo, nombre, descripcion, fecha.toString(),
                    numero, likes, revistaCodigo, archivo, precio, autor, email, revista);

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NumeroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
