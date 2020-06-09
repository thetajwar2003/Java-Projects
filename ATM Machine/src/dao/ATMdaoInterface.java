package dao;
import java.sql.*;

public interface ATMdaoInterface {
    boolean checkUser(String id, int pin) throws SQLException;
    void createUser(String id, int pin, String ssn, String name) throws SQLException;
    String getName(String id) throws SQLException;
    double getCheckingBalance(String id) throws SQLException;
    double getSavingBalance(String id) throws SQLException;
    void checkingWithdrawal(String id, double amount) throws SQLException;
    void savingWithdrawal(String id, double amount) throws SQLException;
    void checkingDeposit(String id, double amount) throws SQLException;
    void savingDeposit(String id, double amount) throws SQLException;
}
