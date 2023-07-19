/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao;

import java.util.List;

/**
 *
 * @author ASUS
 */
public interface DAO<T, K> {
    void insert(T record);
    void update(T record);
    void delete(K idRecord);
    T get(K idRecord);
    List<T> getAll();
}
