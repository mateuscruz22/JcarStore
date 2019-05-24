/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.dao;

import java.util.List;

/**
 *
 * @author Mateus Araújo Cruz
 * @param <T>
 */
public interface IDAO <T> {
    
    boolean insert(T t);
    
    boolean remove(int id);
    
    boolean remove(T t);
    
    boolean update(int id);
    
    boolean update(T t);
   
    T getObjectById(int id);
    
    List<T> getAll();
    
}
