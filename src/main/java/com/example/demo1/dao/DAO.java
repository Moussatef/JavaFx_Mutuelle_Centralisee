package com.example.demo1.dao;

import com.example.demo1.connection.DatabaseConnection;
import java.sql.Connection;

public abstract class DAO<T> {
    public DatabaseConnection connectNow = new DatabaseConnection();
    public Connection connectDB = connectNow.getConnection("mutuelle_centralisee","root","tooor");

    /**
     * Permet de récupérer un objet via son ID
     * @param id
     * @return
     */
    public abstract T find(int id);

    /**
     * Permet de créer une entrée dans la base de données
     * par rapport à un objet
     * @param obj
     */
    public abstract T create(T obj);

    /**
     * Permet de mettre à jour les données d'une entrée dans la base
     * @param obj
     */
    public abstract T update(T obj);

    /**
     * Permet la suppression d'une entrée de la base
     * @param obj
     */
    public abstract void delete(T obj);



}
