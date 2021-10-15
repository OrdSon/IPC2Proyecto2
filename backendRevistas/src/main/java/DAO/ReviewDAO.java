/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Review;
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
public class ReviewDAO extends DAO {

    String INSERTAR_REVIEW = "INSERT INTO review (likes, comentario, usuario_codigo, numero_codigo) VALUES (?,?,?,?)";
    String SELECCIONAR_REVIEWS = "SELECT * FROM review";
    String SELECCIONAR_UNA_REVIEW = "SELECT * FROM review WHERE codigo = ?";
    String ELIMINAR_REVIEW = "DELETE * FROM review WHERE codigo = ?";
    String SELECCIONAR_ULTIMA = "SELECT codigo FROM anuncio ORDER BY codigo DESC LIMIT 1;";

    @Override
    public ArrayList<Review> listar() {

        ArrayList<Review> usuarios = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_REVIEWS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Review review = getReview(resultSet);
                if (review != null) {
                    usuarios.add(review);
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
    Usa el codigo de review para obtener un registro
     */
    public Review listarCodigo(int codigo) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECCIONAR_UNA_REVIEW);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Review review = getReview(resultSet);
                return review;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
    EDITAR
    Recibe una review y la usa para editar un registro ya existente
     */
//    public boolean editar(Review review) {
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REVIEW);
//
//            preparedStatement.setDouble(1, review.getCapital());
//            preparedStatement.setInt(2, review.getCodigo());
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
    Usa un objeto Review para añadir un registro a la base de datos
     */
    public boolean añadir(Review review) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_REVIEW);
            preparedStatement.setInt(1, review.getLikes());
            preparedStatement.setString(2, review.getComentario());
            preparedStatement.setInt(3, review.getUsuarioCodigo());
            preparedStatement.setInt(4, review.getNumeroCodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /*
    ELIMINAR
    Toma el codigo de una review y lo usa para encontrar al objetivo
    y eliminarlo de la base de datos
     */
    public boolean eliminar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ELIMINAR_REVIEW);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private Review getReview(ResultSet resultSet) {
        try {
            int codigo = resultSet.getInt("codigo");
            int likes = resultSet.getInt("likes");
            String comentario = resultSet.getString("comentario");
            int usuarioCodigo = resultSet.getInt("usuario_codigo");
            int numeroCodigo = resultSet.getInt("numero_codigo");

            return new Review(codigo, likes, comentario, usuarioCodigo, numeroCodigo);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
