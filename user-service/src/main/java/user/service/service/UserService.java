package user.service.service;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import user.service.Database;
import user.service.model.UserModel;

public class UserService {

  public static ArrayList<UserModel> all() throws SQLException {
    Connection db = Database.getConnection();
    Statement stmt = db.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM users");

    ArrayList<UserModel> users = new ArrayList<>();
    while(rs.next()) {
      users.add(new UserModel(rs.getInt("id"), rs.getString("email"), rs.getString("name")));
    }

    return users;
  }

  public static UserModel findById(int id) throws SQLException {
    Connection db = Database.getConnection();
    Statement stmt = db.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id="+id);

    UserModel user = null;
    while(rs.next()) {
      user = new UserModel(rs.getInt("id"), rs.getString("email"), rs.getString("name"));
    }

    return user;
  }

  public static int store(String email, String name) throws SQLException {
    ArrayList<UserModel> users = all();
    int id = 1;
    for(UserModel u: users) {
      id = u.id;
    }

    Connection db = Database.getConnection();
    PreparedStatement stmt = db.prepareStatement("INSERT INTO users VALUES(?, ?, ?)");
    stmt.setInt(1, ++id);
    stmt.setString(2, email);
    stmt.setString(3, name);
    stmt.execute();

    return id;
  }

}
