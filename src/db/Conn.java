package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by David on 2017/2/9.
 */
public class Conn
{
    public Connection getCon()
    {
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://123.206.204.252:3306/bikeserver?user=BikeServer&password=qaz13047409865";
            conn = DriverManager.getConnection(url);
//            System.out.println(conn.getMetaData().getURL());
            return conn;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
