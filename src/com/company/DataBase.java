package com.company;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

public class DataBase {

    public void DB(){
        Connection connection;
        Driver driver;

        try{
            driver = new FabricMySQLDriver();
        }catch(SQLException ex){
            System.out.println("Ошибка при создании драйвера.");
            return;  //выход из программы
        }
    }



}
