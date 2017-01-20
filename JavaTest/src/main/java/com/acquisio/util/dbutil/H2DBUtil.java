package com.acquisio.util.dbutil;

import org.h2.tools.Server;

import java.sql.*;

/**
 * employees                             projects
 * +---------------+---------+           +---------------+---------+
 * | id            | int     |<----+  +->| id            | int     |
 * | first_name    | varchar |     |  |  | title         | varchar |
 * | last_name     | varchar |     |  |  | start_date    | date    |
 * | salary        | int     |     |  |  | end_date      | date    |
 * | department_id | int     |--+  |  |  | budget        | int     |
 * +---------------+---------+  |  |  |  +---------------+---------+
 * |  |  |
 * departments                  |  |  |  employees_projects
 * +---------------+---------+  |  |  |  +---------------+---------+
 * | id            | int     |<-+  |  +--| project_id    | int     |
 * | name          | varchar |     +-----| employee_id   | int     |
 * +---------------+---------+           +---------------+---------+
 */
public class H2DBUtil {

    private final static String DB_URL = "jdbc:h2:tcp://localhost/~/acquisio";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    public static void startDatabase() {
        try {
            Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
            Class.forName("org.h2.Driver");

            initSchema();
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initSchema() throws SQLException {
        try (Connection conn = getConnection()) {
            dropTable(conn, "employees_projects");
            dropTable(conn, "projects");
            dropTable(conn, "employees");
            dropTable(conn, "departments");
            conn.createStatement().execute("CREATE TABLE departments (id int, name varchar);");
            conn.createStatement().execute("CREATE TABLE employees (id int, first_name varchar, last_name varchar, salary int, department_id int);");
            conn.createStatement().execute("CREATE TABLE projects (id int, title varchar, start_date date, end_date date, budget int);");
            conn.createStatement().execute("CREATE TABLE employees_projects (project_id int, employee_id int);");
        }
    }

    private static void initData() throws SQLException {
        try (Connection conn = getConnection()) {
            // Insert departments
            conn.createStatement().execute("Insert into DEPARTMENTS (ID,NAME) values (1,'Reporting');");
            conn.createStatement().execute("Insert into DEPARTMENTS (ID,NAME) values (2,'Engineering');");
            conn.createStatement().execute("Insert into DEPARTMENTS (ID,NAME) values (3,'Marketing');");
            conn.createStatement().execute("Insert into DEPARTMENTS (ID,NAME) values (4,'Biz Dev');");
            conn.createStatement().execute("Insert into DEPARTMENTS (ID,NAME) values (5,'Silly Walks');");

            // Employees
            conn.createStatement().execute("Insert into EMPLOYEES (ID,FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID) values (1,'John','Smith',20000,'1');");
            conn.createStatement().execute("Insert into EMPLOYEES (ID,FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID) values (2,'Ava','Muffinson',10000,'5');");
            conn.createStatement().execute("Insert into EMPLOYEES (ID,FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID) values (3,'Cailin','Ninson',30000,'2');");
            conn.createStatement().execute("Insert into EMPLOYEES (ID,FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID) values (4,'Mike','Peterson',20000,'2');");
            conn.createStatement().execute("Insert into EMPLOYEES (ID,FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID) values (5,'Ian','Peterson',80000,'2');");
            conn.createStatement().execute("Insert into EMPLOYEES (ID,FIRST_NAME,LAST_NAME,SALARY,DEPARTMENT_ID) values (6,'John','Mills',50000,'3');");

            // Projects
            conn.createStatement().execute("Insert into PROJECTS (ID,TITLE,START_DATE,END_DATE,BUDGET) values (1,'Build a cool site',to_timestamp('11-10-28 18:19:56.769000000','RR-MM-DD HH24:MI:SSXFF'),to_timestamp('12-01-26 18:19:56.769000000','RR-MM-DD HH24:MI:SSXFF'),1000000);");
            conn.createStatement().execute("Insert into PROJECTS (ID,TITLE,START_DATE,END_DATE,BUDGET) values (2,'Update TPS Reports',to_timestamp('11-07-20 18:19:56.769000000','RR-MM-DD HH24:MI:SSXFF'),to_timestamp('11-10-28 18:19:56.769000000','RR-MM-DD HH24:MI:SSXFF'),100000);");
            conn.createStatement().execute("Insert into PROJECTS (ID,TITLE,START_DATE,END_DATE,BUDGET) values (3,'Design 3 New Silly',to_timestamp('09-05-11 18:19:56.769000000','RR-MM-DD HH24:MI:SSXFF'),to_timestamp('09-08-19 18:19:56.769000000','RR-MM-DD HH24:MI:SSXFF'),100);");

            // Employees_Projects
            conn.createStatement().execute("Insert into EMPLOYEES_PROJECTS (PROJECT_ID,EMPLOYEE_ID) values (1,3);");
            conn.createStatement().execute("Insert into EMPLOYEES_PROJECTS (PROJECT_ID,EMPLOYEE_ID) values (1,4);");
            conn.createStatement().execute("Insert into EMPLOYEES_PROJECTS (PROJECT_ID,EMPLOYEE_ID) values (1,5);");
            conn.createStatement().execute("Insert into EMPLOYEES_PROJECTS (PROJECT_ID,EMPLOYEE_ID) values (2,1);");
            conn.createStatement().execute("Insert into EMPLOYEES_PROJECTS (PROJECT_ID,EMPLOYEE_ID) values (3,2);");
        }
    }

    private static void dropTable(Connection conn, String tableName) {
        try {
            conn.createStatement().execute("DROP TABLE " + tableName + ";");
        } catch (SQLException sqle) {
            // Clean-up tables
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.
                getConnection(DB_URL, DB_USER, DB_PASSWORD);
        System.out.println("Connection Established: " + conn.getMetaData().getDatabaseProductName() + "/" + conn.getCatalog());
        return conn;
    }

    public static void stopDatabase() throws SQLException {
        Server.shutdownTcpServer("tcp://localhost:9092", "", true, true);
    }

    public static void displayTableRows(Connection conn, String tableName) throws SQLException {
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM " + tableName);
        System.out.println();
        System.out.println("================");
        System.out.println("TABLE NAME : " + tableName);
        displayResultSet(resultSet);
    }

    public static void displayResultSet(ResultSet resultSet) throws SQLException {
        System.out.println("----------------");
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.print("\t" + metaData.getColumnName(i));
        }
        System.out.println();
        while (resultSet.next()) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.print("\t" + resultSet.getString(i));
            }
            System.out.println();
        }
        System.out.println("================");
    }
}
