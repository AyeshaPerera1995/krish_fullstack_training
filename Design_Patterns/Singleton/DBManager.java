package lk.codelabs.traning.java.designpattern.singleton;

import javax.naming.CompositeName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static volatile Connection connection;
    private static volatile DBManager dbManager;

    private DBManager(){
        if(dbManager != null){
            throw new RuntimeException("Please use getDBManager method");
        }
    }

    public static DBManager getDbManager() {
        if(dbManager == null){
            synchronized (DBManager.class){
                if(dbManager == null) {
                    dbManager = new DBManager();
                }
            }
        }

        return dbManager;
    }

    public Connection getConnection(){

        if (connection == null){
            synchronized (DBManager.class){
                if (connection == null){
                    String url = "jdbc:derby:memory:sample;create=true";
                    try {
                        connection = DriverManager.getConnection(url);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

}








//    private static volatile DBManager dbManage = new DBManager();
//
//    private DBManager(){
//
//    }
//
//    public static DBManager getDbManager() {
//        return dbManage;
//    }
