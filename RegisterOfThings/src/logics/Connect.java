package logics;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Created by Andrey_pers on 01.11.2016.
 */
public class Connect implements IConnect {
   private final String name = "postgres";
   private final String password = "0000";
   private final String path = "jdbc:postgresql://localhost:5434/ShopBase";
    private Connection connection = null;

    public Connection ConnectBD()
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection= DriverManager.getConnection(path,name,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(connection!=null){
            System.out.println("Success");
        }

        return connection;
    }

    public boolean IsConnection()
    {
        if(connection!=null){
            return true;
        }else {
            return false;
        }
    }

    public void connectClose()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
