
package app.dao.sqlite;

import app.dao.interfaces.CategoryDAO;
import app.dao.exceptions.DAOException;
import app.models.Shelv;
import app.models.connections.DBConnection1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SQLiteCategoryDAO1 implements CategoryDAO {
    public void createCategory(Shelv category) {
        try (Connection connection = DBConnection1.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Category (category) VALUES (?)")) {
            preparedStatement.setString(1, category.getCategory());
            preparedStatement.executeUpdate();
            System.out.println("Categoría creada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la categoría: " + e.getMessage());
        }
    }

    public List<Shelv> getAllCategories() {
        List<Shelv> categories = new ArrayList<>();
        try (Connection connection = DBConnection1.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Category")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String category = resultSet.getString("category");
                Shelv categoryObj = new Shelv(category);
                categories.add(categoryObj);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las categorías: " + e.getMessage());
        }
        return categories;
    }

    public void updateCategory(Shelv category) {
        try (Connection connection = DBConnection1.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Category SET category = ? WHERE id = ?")) {
            preparedStatement.setString(1, category.getCategory());
            preparedStatement.setLong(2, category.getId());
            preparedStatement.executeUpdate();
            System.out.println("Categoría actualizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar la categoría: " + e.getMessage());
        }
    }

    public void deleteCategory(int categoryId) {
        try (Connection connection = DBConnection1.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Category WHERE id = ?")) {
            preparedStatement.setInt(1, categoryId);
            preparedStatement.executeUpdate();
            System.out.println("Categoría eliminada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar la categoría: " + e.getMessage());
        }
    }

    @Override
    public void insert(Shelv record) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Shelv record) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Long idRecord) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Shelv get(Long idRecord) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Shelv> getAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}