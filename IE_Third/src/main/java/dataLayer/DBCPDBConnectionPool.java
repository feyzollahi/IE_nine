package dataLayer;


import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * do not reinvent the wheel!!!
 *
 * you can use DBCP or other libraries.
 *
 * @see <a href="https://www.baeldung.com/java-connection-pooling">A Simple Guide to Connection Pooling in Java</a>
 *
 * */
public class DBCPDBConnectionPool {
    private static BasicDataSource ds = new BasicDataSource();
    private final static String dbURL = "jdbc:mysql://localhost:3306/joboonja?useUnicode=yes&characterEncoding=UTF-8";

    static {
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//
        ds.setUrl(dbURL);
        ds.setMinIdle(10);
        ds.setMaxIdle(20);
    }

    public static Connection getConnection() throws SQLException {
//        ds.set

        return DriverManager.getConnection(dbURL, "root", "test");
    }

    private DBCPDBConnectionPool(){ }
}