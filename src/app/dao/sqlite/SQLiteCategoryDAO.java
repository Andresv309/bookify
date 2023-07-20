
package app.dao.sqlite;

import app.dao.interfaces.CategoryDAO;
import app.dao.exceptions.DAOException;
import app.models.Category;
import app.models.connections.DBConnection1;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SQLiteCategoryDAO implements CategoryDAO {
    public void createCategory(Category category) {
        try (Connection connection = DBConnection1.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Category (category) VALUES (?)")) {
            preparedStatement.setString(1, category.getCategory());
            preparedStatement.executeUpdate();
            System.out.println("Categoría creada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la categoría: " + e.getMessage());
        }
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = DBConnection1.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Category")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String category = resultSet.getString("category");
                Category categoryObj = new Category(id, category);
                categories.add(categoryObj);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las categorías: " + e.getMessage());
        }
        return categories;
    }

    public void updateCategory(Category category) {
        try (Connection connection = DBConnection1.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Category SET category = ? WHERE id = ?")) {
            preparedStatement.setString(1, category.getCategory());
            preparedStatement.setInt(2, category.getId());
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
    public void insert(Category record) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Category record) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Long idRecord) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Category get(Long idRecord) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Category> getAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}