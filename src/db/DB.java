package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

  private static Connection connection = null;

  public static Connection getConnection() {

    if (connection == null) {
      try {
        Properties props = loadProperties();
        String url = props.getProperty("dburl");
        connection = DriverManager.getConnection(url, props);
      } catch (SQLException ex) {
        throw new DbException(ex.getMessage());
      }
    }
    return connection;
  }

  private static Properties loadProperties() {
    try (FileInputStream fs = new FileInputStream("src/db/db.properties")) {

      Properties props = new Properties();
      props.load(fs);
      return props;

    } catch (IOException e) {
      throw new DbException(e.getMessage());
    }
  }

  public static void closeConnection() {

    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        throw new DbException(e.getMessage());
      }
    }
  }
  
  public static void closeStatement(Statement statement) {
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException ex) {
        throw new DbException(ex.getMessage());
      }
    }
  }

}
