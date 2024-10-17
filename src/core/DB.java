/*
 * DB.java
 * this class contains the methods for basic database operations
 */
package core;

/**
 *
 * @author admin
 */
import java.sql.*;

public class DB {
    //1.Get Connection method --> Driver , getConnectuonn , retuen con
    //2.update mehtod --> pass the query for updation
    //3.Retrieve Method --> pass the query for updation
    static Connection con = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    public static <u> Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:ExamSeatingManagement.sqlite");
        }
        catch (Exception e) {
            System.out.println("Exception" + e);
        }
        return con;
    }

    public static boolean executeUpdate(String query) {
        boolean f = false;
        try {
            con = getConnection();
            stmt = con.createStatement();
            int b = stmt.executeUpdate(query);
            if (b > 0) {
                f = true;
            }
            else {
                f = false;
            }

        } 
        catch (Exception e) {
            System.out.println("Exception" + e);
        }
        finally{
            DB.flushStatementOnly();
        }
        return f;
    }

    /**
     *
     * @param <u>
     * @param sql
     * @return
     */
    public static <u> ResultSet executeQuery(String sql) {
        try {
            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        }
        catch (Exception e) {
            System.out.println("Exception" + e);
        }
        return rs;
    }
    public static void flushStatementOnly(){
        {
        try {
            stmt.close();
            //conn.close();
        }
        catch(SQLException ex){
            System.err.print(ex.toString()+" >> CLOSING DB");
        }
        }
    }
    public static void close() {
        try {
            con.close();
            stmt.close();
            rs.close();
        }
        catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }
}
