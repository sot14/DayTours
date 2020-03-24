package Daytours.Database;

import java.sql.*;

public class DataBaseManager {

    private String uName;
    private String pWord;
    private String url;
    private Connection db;

    public DataBaseManager() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        uName = "fezqdgur";
        pWord = "ibGl_wiv1-uiiJkJZ_xkbNpAcy46LWB9";
        url = "jdbc:postgresql://kandula.db.elephantsql.com:5432/fezqdgur";

        db = DriverManager.getConnection(url, uName, pWord);
    }

    public void test() throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT * FROM review";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
        }

    }

}
