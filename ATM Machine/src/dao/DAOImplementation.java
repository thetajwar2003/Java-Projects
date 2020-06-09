package dao;
import util.DBConnection;

import java.sql.*;

import java.sql.SQLException;

public class DAOImplementation implements  ATMdaoInterface{
    static Connection con = DBConnection.getConnection();

    @Override
    public boolean checkUser(String id, int pin) throws SQLException {
        String query = "select pin from user where id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, id);
        ResultSet set = ps.executeQuery();
        while(set.next()){
            if(set.getInt("pin") == pin) return true;
        }
        return false;
    }

    @Override
    public void createUser(String id, int pin, String ssn, String name) throws SQLException {
        String query = "insert into user values(?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, id);
        ps.setInt(2, pin);
        ps.setString(3, ssn);
        ps.setString(4, name);
        ps.executeUpdate();
        String accountQuery = "insert into account values(?, 100.00, 100.00)";
        PreparedStatement sp = con.prepareStatement(accountQuery);
        sp.setString(1, id);
        sp.executeUpdate();
    }

    @Override
    public String getName(String id) throws SQLException {
        String query = "select name from user where id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, id);
        ResultSet set = ps.executeQuery();
        set.next();
        return set.getString("name");
    }

    @Override
    public double getCheckingBalance(String id) throws SQLException {
        String query = "select checking from account where id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, id);
        ResultSet set = ps.executeQuery();
        set.next();
        return set.getInt("checking");
    }

    @Override
    public double getSavingBalance(String id) throws SQLException {
        String query = "select savings from account where id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, id);
        ResultSet set = ps.executeQuery();
        set.next();
        return set.getInt("savings");
    }

    @Override
    public void checkingWithdrawal(String id, double amount) throws SQLException {
        String query = "update account set checking = checking - ? where id = ?";
        PreparedStatement ps =  con.prepareStatement(query);
        ps.setDouble(1, amount);
        ps.setString(2, id);
        ps.executeUpdate();
    }

    @Override
    public void savingWithdrawal(String id, double amount) throws SQLException {
        String query = "update account set savings = savings - ? where id = ?";
        PreparedStatement ps =  con.prepareStatement(query);
        ps.setDouble(1, amount);
        ps.setString(2, id);
        ps.executeUpdate();
    }

    @Override
    public void checkingDeposit(String id, double amount) throws SQLException {
        String query = "update account set checking = checking + ? where id = ?";
        PreparedStatement ps =  con.prepareStatement(query);
        ps.setDouble(1, amount);
        ps.setString(2, id);
        ps.executeUpdate();
    }

    @Override
    public void savingDeposit(String id, double amount) throws SQLException {
        String query = "update account set savings = savings + ? where id = ?";
        PreparedStatement ps =  con.prepareStatement(query);
        ps.setDouble(1, amount);
        ps.setString(2, id);
        ps.executeUpdate();
    }
}
