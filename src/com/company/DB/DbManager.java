package com.company.DB;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DbManager {

    public static Connection connection;  //Объект Connection представляет собой соединение с БД.
    public static Statement statement;  //Объект Statement используется для выполнения SQL-запросов к БД.
    public static ResultSet resultSet;  //ResultSet содержит все строки и предоставляет доступ к данным в этих строках.

    /** Подключение к БД */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");  //Class.forName() приводит к загрузке класса и инициализации его статической части.
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/location", "root", "root");
        System.out.println("Установлено соединение с БД.");
        return connection;
    }

    /** Создание таблицы */
    public static void createTable() throws Exception {
        try {
            connection = getConnection();
            PreparedStatement ps_create = connection.prepareStatement("CREATE TABLE IF NOT EXISTS chatbot(id INT NOT NULL AUTO_INCREMENT, our_key VARCHAR(255), our_value VARCHAR(255), PRIMARY KEY(id))");
            ps_create.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("Создание таблицы завершено.");
        }
    }

    /** Добавление в таблицу информации */
    public static void postTable() throws Exception {
        String hello_key = "привет";
        String hello_value = "hello";

        try {
            connection = getConnection();
            PreparedStatement ps_post = connection.prepareStatement("INSERT INTO chatbot(our_key, our_value) VALUES ('"+hello_key+"','"+hello_value+"')");
            ps_post.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            System.out.println("Таблица заполнена.");
        }
    }
}
