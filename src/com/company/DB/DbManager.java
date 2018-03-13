package com.company.DB;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DbManager {

    public static Connection connection;  //Объект Connection представляет собой соединение с БД.
    public static Statement statement;  //Объект Statement используется для выполнения SQL-запросов к БД.
    public static ResultSet resultSet;  //ResultSet содержит все строки и предоставляет доступ к данным в этих строках.

    /** Подключение к БД */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");  //Class.forName() приводит к загрузке класса и инициализации его статической части.
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/location", "root", "root");
        System.out.println("Установлено соединение с БД.");
        return connection;
    }
}
