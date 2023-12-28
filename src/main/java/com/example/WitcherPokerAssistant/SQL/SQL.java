package com.example.WitcherPokerAssistant.SQL;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQL {

    private static final String url = "jdbc:mysql://localhost:3306/dbwitcher";
    private static final String user = "root";
    private static String password;
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    public static String getPassword()  {
        String password = null;
        InputStream inputStream = SQL.class.getClassLoader().getResourceAsStream("password.txt");
        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                password = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Файл не найден");
        }
        return password;
    }


    public SQL(){

    }
    public static int addGame(int idPlayer){
        int gameId = -1;
        try (Connection conn = DriverManager.getConnection(url, user, getPassword())) {
            String sql = "{call InsertGame(?, ?)}";
            CallableStatement stmt = conn.prepareCall(sql);

            stmt.setInt(1, idPlayer);
            stmt.registerOutParameter(2, Types.INTEGER);

            stmt.execute();

            int result = stmt.getInt(2);
            gameId = result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return gameId;
    }

    public static ListRecordHistory viewHistory (int pagination, int page, int playerId,ListRecordHistory listRecordHistory){
        try{
            con = DriverManager.getConnection(url, user, getPassword());
            stmt = con.createStatement();
            rs = stmt.executeQuery("CALL view_history(" + page + ", " + pagination + ", " + playerId + ");");
            //List<RecordHistory> resultList = new ArrayList<RecordHistory>();
            while (rs.next()){
                //RecordHistory recordHistory = new RecordHistory(rs.getInt(1),rs.getBoolean(2), rs.getBoolean(3));
                listRecordHistory.add(rs.getInt(2),rs.getFloat(3), rs.getBoolean(4));
            }
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {

            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return listRecordHistory;
    }
    public static boolean addResult(int idGame, float predict, boolean result){
        try{
            con = DriverManager.getConnection(url, user, getPassword());
            stmt = con.createStatement();
            rs = stmt.executeQuery("CALL add_result(" + idGame + ", " + predict + ", " + result + ");");
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {

            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return true;
    }
    public static int checkResult(String login, String passwordUser){
        int playerId = -1;
        try (Connection conn = DriverManager.getConnection(url, user, getPassword())) {
            String sql = "{call check_user(?, ?, ?)}";
            CallableStatement stmt = conn.prepareCall(sql);

            stmt.setString(1, login);
            stmt.setString(2, passwordUser);
            stmt.registerOutParameter(3, Types.BOOLEAN);

            stmt.execute();

            int result = stmt.getInt(3);
            playerId = result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerId;
    }
    static boolean executeQuery(QUERY typeQuery){
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, getPassword());

            // getting Statement object to execute query
            stmt = con.createStatement();
            switch(typeQuery){
                case ADD_RESULT ->{

                }
                case CHECK_USER ->{

                }
                case VIEW_HISTORY -> {

                }
                default -> {return false;}
            }
            // executing SELECT query
            //rs = stmt.executeQuery(query);

            while (rs.next()) {
                //int count = rs.getInt(1);
                System.out.println(rs.getInt("id") + "  "
                        + rs.getInt("game_id") + " "
                        + rs.getDouble("algorithm_win_probability") + " "
                        + rs.getString("actual_outcome"));
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    return true;
    }
}
