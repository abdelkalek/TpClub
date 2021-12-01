package com.example.tpclub.Service;
import java.util.List;
public interface ICrudMethod<T> {
    List<T> retrieveAll();
    int ajouter(T c);
    void delete(Integer id);
    T update(T t, int id);
    T retrieve(Integer id);
    long nbrObej();
}
