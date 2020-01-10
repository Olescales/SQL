package org.example.DAO;

import org.example.Entity.Account;
import org.example.Entity.User;

import java.util.List;

public interface MySQLDAO {
    User getUser(int userId);
    List<Account> getAccountList();
}
