package dao;

import java.util.List;

public interface Dao<T> {
    
    List<T> getAll();
    
    void add(T entity);
    
    T findById(int id);
    
    T findByUsername(String username);
    
    void remove(int id);
    
    void update(int id, T entity);
    
    T login(String username, String password);
}
