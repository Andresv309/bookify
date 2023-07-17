/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.models.CategoryDAO;
import app.views.CategoryView;

public class CategoryController {
    private CategoryView categoryView;
    private CategoryDAO categoryDAO;

    public CategoryController(CategoryView categoryView, CategoryDAO categoryDAO) {
        this.categoryView = categoryView;
        this.categoryDAO = categoryDAO;
    }

    public void initialize() {
        // Configurar escuchadores de eventos en la vista y realizar otras tareas de inicialización
    }

    // Métodos de controlador para cada operación CRUD, que invocan los métodos correspondientes en el modelo y actualizan la vista según sea necesario
}