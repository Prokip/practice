package mypractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        CreateTable regist= new CreateTable();
        try {
        regist.createDbTable();
        regist.addAdmin();
        } catch (Exception e) { e.printStackTrace(); }

    }

    private void createDbTable() throws Exception {
        Connection conect = DBConnection.getDBConnectin();
        Statement statem = null;
        String createTableSQL = "CREATE TABLE SECUR("
                + "user_id INTEGER NOT NULL PRIMARY KEY, "
                + "name VARCHAR(20) NOT NULL, "
                + "last_name VARCHAR(20) NOT NULL, "
                + "email VARCHAR(20) NOT NULL, "
                + "active INT DEFAULT NULL, "
                + "password VARCHAR(12) NOT NULL)";

        String createTableRole = "CREATE TABLE ROLE("
                + "role_id INT NOT NULL PRIMARY KEY, "
                + "role VARCHAR(20) NOT NULL) ";

        String createTableUserR = "CREATE TABLE SOMTH("
                + "user_id INTEGER NOT NULL PRIMARY KEY, "
                + "role_id INTEGER NOT NULL PRIMARY KEY, "
                + "CONSTRAINT fk_tests_role,"
                + "FOREIGN KEY (role_id), "
                + "REFERENCES SECURE (user_id))";

        try {
            statem = conect.createStatement();

            statem.execute(createTableSQL);
            statem.execute(createTableRole);
            statem.execute(createTableUserR);
            System.out.println("Table \"SECUR\" is created!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (statem != null) { statem.close(); }
            if (conect != null) { conect.close(); }
        }
    }

    private void addAdmin() throws Exception {
            try {
                DBConnection.getDBConnectin();

                System.out.println("зв'язок налагоджено");

                String insertIntoTable = "INSERT INTO ROLE(role_id, role) VALUES (1, 'Admin')";

                PreparedStatement pSt=DBConnection.getDBConnectin().prepareStatement(insertIntoTable);
                pSt.executeUpdate();
                pSt.close();
            }catch (Exception e) { System.out.println(e.getMessage()); }
            finally {
                if (DBConnection.getDBConnectin() != null) { DBConnection.getDBConnectin().close(); }
            }
    }


}
