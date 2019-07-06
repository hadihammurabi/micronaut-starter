package transaction.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
  private static Connection connection;

  public static Connection getConnection() throws SQLException {
    if (connection == null) {
      connection = DriverManager.getConnection("jdbc:mariadb://localhost/shop", "root", "root");
    }

    return connection;
  }

}
