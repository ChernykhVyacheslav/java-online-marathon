package com.chernykh.sprint10;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {

    private static final String CONNECTION_URL = "jdbc:h2:mem:test";

    private static final String SQL_CREATE_SCHEMA = "CREATE SCHEMA ";
    private static final String SQL_DROP_SCHEMA = "DROP SCHEMA ";
    private static final String SQL_SET_SCHEMA = "SET SCHEMA ";

    private static final String SQL_CREATE_TABLE_ROLES = "CREATE TABLE Roles" +
            "(id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, " +
            " roleName VARCHAR(15) NOT NULL UNIQUE);";

    private static final String SQL_CREATE_TABLE_DIRECTIONS = "CREATE TABLE Directions" +
            "(id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, " +
            " directionName VARCHAR(15) NOT NULL UNIQUE);";

    private static final String SQL_CREATE_TABLE_PROJECTS = "CREATE TABLE Projects" +
            "(id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, " +
            " projectName VARCHAR(15) NOT NULL UNIQUE, " +
            " directionId INT, " +
            " FOREIGN KEY (directionId) REFERENCES Directions (id));";

    private static final String SQL_CREATE_TABLE_EMPLOYEE = "CREATE TABLE Employee" +
            "(id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, " +
            " firstName VARCHAR(15) NOT NULL, " +
            " roleId    INT, " +
            " FOREIGN KEY (roleId) REFERENCES Roles (id), " +
            " projectId INT, " +
            " FOREIGN KEY (projectId) REFERENCES Projects (id));";

    private static final String SQL_DROP_TABLE = "DROP TABLE ";

    private static final String SQL_INSERT_TABLE_ROLES = "INSERT INTO Roles(roleName) VALUES ?;";

    private static final String SQL_INSERT_TABLE_DIRECTIONS = "INSERT INTO Directions(directionName) VALUES ?;";

    private static final String SQL_INSERT_TABLE_PROJECTS = "INSERT INTO Projects(projectName, directionId) VALUES (?, ?);";

    private static final String SQL_INSERT_TABLE_EMPLOYEE = "INSERT INTO Employee(firstName, roleId, projectId) VALUES (?, ?, ?);";

    private static final String SQL_GET_ROLE_ID = "SELECT id FROM Roles WHERE roleName = ?;";

    private static final String SQL_GET_DIRECTION_ID = "SELECT id FROM Directions WHERE directionName = ?;";

    private static final String SQL_GET_PROJECT_ID = "SELECT id FROM Projects WHERE projectName = ?;";

    private static final String SQL_GET_EMPLOYEE_ID = "SELECT id FROM Employee WHERE firstName = ?;";

    private static final String SQL_GET_ALL_ROLES = "SELECT roleName FROM Roles;";
    private static final String SQL_GET_ALL_DIRECTIONS = "SELECT directionName FROM Directions;";
    private static final String SQL_GET_ALL_PROJECTS = "SELECT projectName FROM Projects;";
    private static final String SQL_GET_ALL_EMPLOYEES = "SELECT firstName FROM Employee;";
    private static final String SQL_GET_ALL_DEVELOPERS = "SELECT Employee.firstName FROM Employee" +
            " JOIN Roles ON Employee.roleId = Roles.id AND Roles.roleName = 'Developer';";
    private static final String SQL_GET_ALL_JAVA_PROJECTS = "SELECT Projects.projectName FROM Projects" +
            " JOIN Directions ON Projects.directionId = Directions.id AND Directions.directionName = 'Java';";
    private static final String SQL_GET_ALL_JAVA_DEVELOPERS = "SELECT Employee.firstName FROM Employee" +
            " JOIN Roles ON Employee.roleId = Roles.id AND Roles.roleName = 'Developer'" +
            " JOIN Projects ON Employee.projectId = Projects.id" +
            " JOIN Directions ON Projects.directionId = Directions.id AND Directions.directionName = 'Java';";

    private static final int VALUE_INDEX = 1;

    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        connection = DriverManager.getConnection(CONNECTION_URL, "", "");
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            closeStatement();
            connection.close();
        }
    }

    public Statement createStatement() throws SQLException {
        statement = connection.createStatement();
        return statement;
    }

    public void closeStatement() throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }

    public void createSchema(String schemaName) throws SQLException {
        try {
            createStatement();
            statement.executeUpdate(SQL_CREATE_SCHEMA + schemaName + ";");
            this.schemaName = schemaName;
        } catch (SQLException e) {
            System.err.println("Cannot create a schema");

            throw new SQLException("Cannot create a schema", e);
        } finally {
            closeStatement();
        }
    }

    public void dropSchema() throws SQLException {
        try {
            createStatement();
            statement.executeUpdate(SQL_DROP_SCHEMA + schemaName + ";");
        } catch (SQLException e) {
            System.err.println("Cannot drop a schema");

            throw new SQLException("Cannot drop a schema", e);
        } finally {
            closeStatement();
        }
    }

    public void useSchema() throws SQLException {
        try {
            createStatement();
            statement.executeUpdate(SQL_SET_SCHEMA + schemaName + ";");
        } catch (SQLException e) {
            System.err.println("Cannot use a schema");

            throw new SQLException("Cannot use a schema", e);
        } finally {
            closeStatement();
        }
    }

    public void createTableRoles() throws SQLException {
        createSQLTable(SQL_CREATE_TABLE_ROLES, "Roles");
    }

    public void createTableDirections() throws SQLException {
        createSQLTable(SQL_CREATE_TABLE_DIRECTIONS, "Directions");
    }

    public void createTableProjects() throws SQLException {
        createSQLTable(SQL_CREATE_TABLE_PROJECTS, "Projects");
    }

    public void createTableEmployee() throws SQLException {
        createSQLTable(SQL_CREATE_TABLE_EMPLOYEE, "Employee");
    }

    private void createSQLTable(String sqlQuery, String errorMessage) throws SQLException {
        try {
            createStatement();
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.err.println("Cannot create a " + errorMessage + " table");

            throw new SQLException("Cannot create a " + errorMessage + " table", e);
        } finally {
            closeStatement();
        }
    }

    public void dropTable(String tableName) throws SQLException {
        try {
            createStatement();
            statement.executeUpdate(SQL_DROP_TABLE + tableName + ";");
        } catch (SQLException e) {
            System.err.println("Cannot drop a " + tableName + " table");

            throw new SQLException("Cannot drop a " + tableName + " table", e);
        } finally {
            closeStatement();
        }
    }

    public void insertTableRoles(String roleName) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT_TABLE_ROLES)) {
            pstmt.setString(VALUE_INDEX, roleName);
            pstmt.executeUpdate();
        } catch (SQLException ex) {

            System.err.println("Cannot insert a new role");

            throw new SQLException("Cannot insert a new role", ex);
        }
    }

    public void insertTableDirections(String directionName) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT_TABLE_DIRECTIONS)) {
            pstmt.setString(VALUE_INDEX, directionName);
            pstmt.executeUpdate();
        } catch (SQLException ex) {

            System.err.println("Cannot insert a new direction");

            throw new SQLException("Cannot insert a new direction", ex);
        }
    }

    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT_TABLE_PROJECTS)) {
            pstmt.setString(VALUE_INDEX, projectName);
            pstmt.setInt(VALUE_INDEX + 1, getDirectionId(directionName));
            pstmt.executeUpdate();
        } catch (SQLException ex) {

            System.err.println("Cannot insert a new project");

            throw new SQLException("Cannot insert a new project", ex);
        }
    }

    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT_TABLE_EMPLOYEE)) {
            pstmt.setString(VALUE_INDEX, firstName);
            pstmt.setInt(VALUE_INDEX + 1, getRoleId(roleName));
            pstmt.setInt(VALUE_INDEX + 2, getProjectId(projectName));
            pstmt.executeUpdate();
        } catch (SQLException ex) {

            System.err.println("Cannot insert a new Employee");

            throw new SQLException("Cannot insert a new Employee", ex);
        }
    }

    public int getRoleId(String roleName) throws SQLException {
        return getId(roleName, SQL_GET_ROLE_ID, "role");
    }

    public int getDirectionId(String directionName) throws SQLException {
        return getId(directionName, SQL_GET_DIRECTION_ID, "direction");
    }

    public int getProjectId(String projectName) throws SQLException {
        return getId(projectName, SQL_GET_PROJECT_ID, "project");
    }

    public int getEmployeeId(String firstName) throws SQLException {
        return getId(firstName, SQL_GET_EMPLOYEE_ID, "employee");
    }

    private int getId(String nameField, String sqlQuery, String errorMessage) throws SQLException {
        ResultSet rs = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sqlQuery)) {
            pstmt.setString(VALUE_INDEX, nameField);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {

            System.err.println("Cannot get a " + errorMessage + " id");

            throw new SQLException("Cannot get a " + errorMessage + " id", ex);
        } finally {
            if(rs != null) {
                rs.close();
            }
        }
        return -1;
    }

    private List<String> getAllElements(String sqlQuery, String elementName) throws SQLException {
        ResultSet resultSet = null;
        try {
            List<String> rolesList = new ArrayList<>();
            createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                rolesList.add(resultSet.getString(VALUE_INDEX));
            }
            return rolesList;
        } catch (SQLException e) {
            System.err.println("Cannot get " + elementName);

            throw new SQLException("Cannot get " + elementName, e);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            closeStatement();
        }
    }

    public List<String> getAllRoles() throws SQLException {
        return getAllElements(SQL_GET_ALL_ROLES, "roles");
    }

    public List<String> getAllDirestion() throws SQLException {
        return getAllElements(SQL_GET_ALL_DIRECTIONS, "directions");
    }

    public List<String> getAllProjects() throws SQLException {
        return getAllElements(SQL_GET_ALL_PROJECTS, "projects");
    }

    public List<String> getAllEmployee() throws SQLException {
        return getAllElements(SQL_GET_ALL_EMPLOYEES, "employees");
    }

    public List<String> getAllDevelopers() throws SQLException {
        return getAllElements(SQL_GET_ALL_DEVELOPERS, "developers");
    }

    public List<String> getAllJavaProjects() throws SQLException {
        return getAllElements(SQL_GET_ALL_JAVA_PROJECTS, "java projects");
    }

    public List<String> getAllJavaDevelopers() throws SQLException {
        return getAllElements(SQL_GET_ALL_JAVA_DEVELOPERS, "java developers");
    }

}

