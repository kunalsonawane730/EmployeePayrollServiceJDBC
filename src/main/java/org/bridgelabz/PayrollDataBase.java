package org.bridgelabz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PayrollDataBase {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_services?characterEncoding=UTF-8";
        String userName = "root";
        String password = "root";

        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        listDrivers();

        try{
            System.out.println("Connecting to database"+jdbcURL);
            con = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful!!!!!!"+con);
        }
        catch(Exception e ) {
            e.printStackTrace();
        }
    }
    public static void listDrivers() {
        /**
         * Enumeration :-
         *
         *  An object that implements the Enumeration interface generates a series of elements, one at a time.
         *  Successive calls to the nextElement method return successive elements of the series.
         */
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}
