package com.bittech.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class DbManager {

    public String username = "root";
    public String password = "root";
    public String dirver = "com.mysql.jdbc.Driver";
    public String url = "jbdc:mysql://localhost:3306/ming";

    public Connection connection = null;
    public Statement statement = null;
    public ResultSet resultSet = null;

    public DbManager() {
    }

    //获取连接
    public Connection getConnection() {
        try {
            Class.forName(dirver);
            System.out.print("it is success that load driver from db");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection success...");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //获取数据集
    public ResultSet executeQueryForUer(String strSql) {
        try {
            connection = this.connection;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(strSql);
            return resultSet;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //关闭
    public void closeConnection(){
        try{
            if (resultSet !=null) resultSet.close();
            if (statement !=null) statement.close();
            if (connection !=null) connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
