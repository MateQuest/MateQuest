package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMySQL {
    static final String driverName = "com.mysql.jdbc.Driver";
    static final String url="jdbc:mysql://localhost/preme2";
    static final String uid="root";
    static final String pwd="";
    private Connection con;

    public ConnectMySQL(){
        try {
            Class.forName(driverName).newInstance();
            this.con = DriverManager.getConnection(url,uid,pwd);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Nie znaleziono sterownika bazy danych");
            System.out.println(e);
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Nie połaczyłem się z bazą " + url);
            System.out.println(e);
            System.exit(1);
        }
    }


    public Statement createStatement() {
        try {
            return con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;
    }
}