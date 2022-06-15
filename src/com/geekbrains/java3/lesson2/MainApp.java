package com.geekbrains.java3.lesson2;

import java.sql.*;

public class MainApp {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement ps;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:dbmain.db");
        stmt = connection.createStatement();
    }

    public static void prepareStatements() throws SQLException {
        ps = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?,?);");
    }

    public static void disconnect() {
        try {
            if(stmt != null) {
                stmt.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection != null) {
                connection.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            connect();
            dropAndCreateTableEx();
            prepareStatements();
            fillTableEx();
            readEx();
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

    }

    private static void readEx() throws SQLException {
        try(ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id < 5;")) {
            while(rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getInt(3));
            }
        }
    }

    private static void fillTableEx() throws SQLException {
        connection.setAutoCommit(false);
        for(int i = 1; i <= 100; i++) {
            ps.setString(1,"Bob" + i);
            ps.setInt(2,50);
            ps.executeUpdate();
        }
        connection.commit();
    }

    private static void dropAndCreateTableEx() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS students;");
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (id KEY AUTOINCREMENT, name TEXT, score INTEGER);");
    }

    private static void deleteEx() throws SQLException {
        stmt.executeUpdate("DELETE FROM students WHERE id = 5;");
    }

    private static void updateEX() throws SQLException {
        stmt.executeUpdate("UPDATE students SET score = 100 WHERE id < 3;");
    }

    private static void insertEX() throws SQLException {
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob',100);");
    }




















}
