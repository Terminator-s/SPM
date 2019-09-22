package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection Instance;
    private static Connection connection;

    // This works according to singleton pattern
    public DbConnection(){
    }

    public static DbConnection getInstance(){
        if(Instance==null){
            Instance= new DbConnection();
        }
        return Instance;
    }

    public static Connection getDBConnection(){

        //This create new connection objects when connection is closed or it is null
        try{
            String driver ="com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/SPM";
            String username = "root";
            String password = "pavi@123";

            if(connection == null || connection.isClosed())
            {
                Class.forName(driver);  //load driver
                connection = DriverManager.getConnection(url,username,password);
                //creating connection
            }

        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return connection;
    }
}
