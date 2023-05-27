package edu.internetstore.internetstore.service;

import java.util.List;

public interface InternetStoreService<T> {
    List<T> getAllData();
    T getDataById(String id);
    void insertData(T element);
    void updateData(T element);
    T getData(T element);

}
