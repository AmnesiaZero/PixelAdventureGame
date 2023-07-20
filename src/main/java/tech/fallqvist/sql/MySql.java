package tech.fallqvist.sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MySql {
    public static Connection getConnection() throws SQLException, IOException {
        Properties sqlProps = new Properties();
        String directoryPath = new File("").getAbsolutePath();
        String propertiesPath = directoryPath + "\\src\\main\\java\\tech\\fallqvist\\sql\\sql.properties";
        sqlProps.load(new FileInputStream(propertiesPath));
        String url = sqlProps.getProperty("url");
        String username = sqlProps.getProperty("username");
        String password = sqlProps.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }

    public static int startNewRunSql(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO `player_store` VALUES (NULL,0,0,0,0,0,0,0,0)");
        return MySql.getIntValueSql(statement.executeQuery("SELECT MAX(id) FROM `player_store`"));
    }

    public static int getIntValueSql(ResultSet resultSet) throws SQLException {
        resultSet.next();
        return resultSet.getInt(1);
    }

    public static void cleanTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM `player_store` WHERE `time_played`=0");
    }


}