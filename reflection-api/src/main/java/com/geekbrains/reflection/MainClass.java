package com.geekbrains.reflection;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MainClass { // создание таблицы с помощью аннотаций
    public static void main(String[] args) {
        Cats cat = new Cats( 1, "Barsik", "White");
        User user = new User(1, "Bob", 30, 200_000, "bob@gmail.com", "1111111","123","1");
//        createTableReflectionExample(cat.getClass());
//        addObjectToTable(cat);
        createTableReflectionExample(user.getClass());
        addObjectToTable(user);
    }

    private static void addObjectToTable(Object obj) {
        Class c  = obj.getClass();
        Connection connection = null;
        PreparedStatement ps = null;
        if(!c.isAnnotationPresent(HTable.class)) {
            throw new RuntimeException("Unable to create table for this class");
        }
        try {
            // INSERT INTO cats (id, name, color) VALUES(...)
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            StringBuilder builder = new StringBuilder("INSERT INTO ");
            //INSERT INTO
            builder.append(((HTable)c.getAnnotation(HTable.class)).name());
            // INSERT INTO cats
            builder.append(" (");
            // INSERT INTO cats (
            Field[] fields = c.getDeclaredFields();
            for(Field f: fields) {
                if(f.isAnnotationPresent(HField.class)) {
                    builder.append(f.getName()).append(", ");
                }
            }
            builder.setLength(builder.length() - 2);
            builder.append(") VALUES (");
            for(Field f: fields) {
                if (f.isAnnotationPresent(HField.class)) {
                    builder.append("?, ");
                }
            }
            builder.setLength(builder.length() - 2);
            builder.append(");");
            ps = connection.prepareStatement(builder.toString());
            int n = 1;
            for(Field f: fields) {
                if (f.isAnnotationPresent(HField.class)) {
                   ps.setObject(n,f.get(obj));
                   n++;
                }
            }
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void createTableReflectionExample(Class c) {
        Map<Class,String> typesMap = new HashMap<>();
        typesMap.put(int.class, "INTEGER");
        typesMap.put(String.class, "TEXT");
        Connection connection = null;
        Statement statement = null;
        if(!c.isAnnotationPresent(HTable.class)) {
            throw new RuntimeException("Unable to create table for this class");
        }
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            statement = connection.createStatement();
            StringBuilder builder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
            // CREATE TABLE
            builder.append(((HTable)c.getAnnotation(HTable.class)).name());
            // CREATE TABLE cats
            builder.append(" (");
            // CREATE TABLE cats (
            Field[] fields = c.getDeclaredFields();
            for(Field f: fields) {
                if(f.isAnnotationPresent(HField.class)) {
                    builder.append(f.getName()).append(" ");
                    builder.append(typesMap.get(f.getClass())).append(", ");
                }
            }
            builder.setLength(builder.length() - 2);
            builder.append(");");
            statement.executeUpdate(builder.toString());

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
