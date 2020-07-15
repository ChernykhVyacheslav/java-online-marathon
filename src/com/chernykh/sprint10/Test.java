package com.chernykh.sprint10;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema("schemaName");
            myUtils.useSchema();
//
            myUtils.createTableRoles();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.createTableEmployee();
//
            myUtils.insertTableRoles("Developer");
            myUtils.insertTableDirections("Java");
            myUtils.insertTableProjects("MoonLight", "Java");
            myUtils.insertTableEmployee("Ivan", "Developer", "MoonLight");
            myUtils.insertTableEmployee("Petro", "Developer", "MoonLight");

            myUtils.dropTable("Employee");
            myUtils.dropTable("Projects");
            myUtils.dropTable("Directions");
            myUtils.dropTable("Roles");
//
            myUtils.dropSchema();
//
            myUtils.closeStatement();
            myUtils.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
