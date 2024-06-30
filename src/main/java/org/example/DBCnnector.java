package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

//kjo klase ben lidhjen me databazen
public class DBCnnector {
    private static final String DB_URL="jdbc:mysql://localhost:3306/student_managment";//test emri i databases
    private static final String DB_USERNAME="root";
    private static final String DB_PASSWORD="root";
    public static Connection getConnection() {
        Connection conn=null;

        try{

            conn= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            if(conn!=null){
                System.out.println("succesfully conection");
            }else{
                System.out.println("failed conection");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
