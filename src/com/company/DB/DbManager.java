package com.company.DB;

import java.sql.*;
import java.util.ArrayList;

public class DbManager {

    public static Connection connection;
    public static PreparedStatement ps;
    public static ResultSet resultSet;

    /** Подключение к БД */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/location", "root", "root");
        System.out.println("Установлено соединение с БД.");
        return connection;
    }

    /** Создание таблицы */
    public static void createTable() throws ClassNotFoundException, SQLException {
        connection = getConnection();
        ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS chatbot(id INT PRIMARY KEY AUTO_INCREMENT, our_key VARCHAR(255), our_value VARCHAR(255))");
        ps.executeUpdate();

        System.out.println("Создание таблицы завершено.");
    }

    /** Добавление в таблицу информации */
    public static void postTable() throws ClassNotFoundException, SQLException {
        String hello_key = "привет";
        String hello_value = "hello";

        connection = getConnection();
        ps = connection.prepareStatement("INSERT INTO chatbot(our_key, our_value) VALUES ('"+hello_key+"','"+hello_value+"')");
        ps.executeUpdate();
    }

    /** Выбор и вывод данных */
    public static ArrayList<String> get() {
        try {
            connection = getConnection();
            ps = connection.prepareStatement("SELECT our_key, our_value FROM chatbot");
            resultSet = ps.executeQuery();

            ArrayList<String> array = new ArrayList<>();

            while (resultSet.next()) {
                System.out.print(resultSet.getString("our_key"));
                System.out.print(" ");
                System.out.println(resultSet.getString("our_value"));

                array.add(resultSet.getString("our_key"));
                array.add(resultSet.getString("our_value"));
            }
            System.out.println("Все записи выбраны!");
            return array;

        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
