package org.example.DAO;

import org.example.Entity.Account;
import org.example.Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnector implements MySQLDAO {
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final String USERNAME = "root";
    private final String PASSWORD = "admin";
    private Connection connection;
    private Statement statement;

    public MySQLConnector() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено.");
            }
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("Не удалось загрузить драйвер.");
        }
    }

    @Override
    public User getUser(int userId) {
        String query = "select * from users where userid = " + userId;
        User user = new User();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                user.setId(resultSet.getInt("userid"));
                user.setName(resultSet.getNString("name"));
                user.setSurName(resultSet.getNString("surname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<Account> getAccountList() {
        String query = "select * from account";
        List<Account> listForReturn = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Account account = new Account();
                account.setAccountId(resultSet.getInt("accountid"));
                account.setAccount(resultSet.getInt("account"));
                account.setUserId(resultSet.getInt("userid"));
                listForReturn.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listForReturn;
    }
}

