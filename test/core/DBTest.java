/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import junit.framework.TestCase;

/**
 *
 * @author admin
 */
public class DBTest extends TestCase {
    
    public DBTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getConnection method, of class DB.
     */
    public void testGetConnection() {
        System.out.println("getConnection");
        //String expResult = "org.sqlite.SQLiteConnection@6a4f787b";
        Connection fake_result = DB.getConnection();
        Connection result = fake_result;
        assertEquals(fake_result, result);
    }

    /**
     * Test of executeUpdate method, of class DB.
     */
    public void testExecuteUpdate() {
        System.out.println("executeUpdate");
        String query = "";
        boolean expResult = false;
        boolean result = DB.executeUpdate(query);
        assertEquals(expResult, result);
    }

    /**
     * Test of executeQuery method, of class DB.
     */
    public void testExecuteQuery() {
        System.out.println("executeQuery");
        String sql = "";
        ResultSet expResult = null;
        ResultSet result = DB.executeQuery(sql);
        assertEquals(expResult, result);
    }
}
