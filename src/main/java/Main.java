import org.example.DAO.MySQLConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        MySQLConnector mySQLConnector = new MySQLConnector();
        mySQLConnector.getUser(4);
        mySQLConnector.getAccountList();

    }
}
