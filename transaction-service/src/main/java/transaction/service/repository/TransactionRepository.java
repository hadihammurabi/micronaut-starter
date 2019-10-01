package transaction.service.repository;

import java.util.ArrayList;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import transaction.service.Database;

import transaction.service.model.TransactionModel;
import transaction.service.model.UserModel;

public class TransactionRepository {
  public static ArrayList<TransactionModel> all() throws SQLException {
    Statement stmt = Database.getConnection().createStatement();
    String query = "SELECT t.number as number, t.total as total, u.id as user_id, u.email as email, u.name as name  FROM transactions t JOIN users u ON t.user_id=u.id";
    ResultSet rs = stmt.executeQuery(query);

    ArrayList<TransactionModel> transactions = new ArrayList<>();
    while(rs.next()) {
      transactions.add(new TransactionModel(rs.getInt("number"), rs.getFloat("total"), new UserModel(rs.getInt("user_id"), rs.getString("email"), rs.getString("name"))));
    }

    return transactions;
  }

  public static ArrayList<TransactionModel> findByNumber(int number) throws SQLException {
    Statement stmt = Database.getConnection().createStatement();
    String query = "SELECT t.number as number, t.total as total, u.id as user_id, u.email as email, u.name as name  FROM transactions t JOIN users u ON t.user_id=u.id WHERE t.number="+number;
    ResultSet rs = stmt.executeQuery(query);

    ArrayList<TransactionModel> transactions = new ArrayList<>();
    while(rs.next()) {
      transactions.add(new TransactionModel(rs.getInt("number"), rs.getFloat("total"), new UserModel(rs.getInt("user_id"), rs.getString("email"), rs.getString("name"))));
    }

    return transactions;
  }
}
