package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    Util util = new Util();
    ArrayList<User> aiba = new ArrayList<>();
    public UserDaoJdbcImpl() {
    }

    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS users"+
                "(id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)NOT NULL," +
                "lastName VARCHAR(100)NOT NULL, " +
                "age VARCHAR(100)NOT NULL);";

        try (Connection conn = Util.connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(SQL);
            System.out.println("Таблица тузулду:");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        String SQL = "DROP TABLE IF EXISTS users";
        try (Connection conn = Util.connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(SQL);
            System.out.println("Таблица очурулду:");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        try (Connection conn = Util.connect();
             PreparedStatement stms = conn.prepareStatement(SQL)) {
            stms.setString(1, name);
            stms.setString(2, lastName);
            stms.setInt(3, age);
            stms.executeUpdate();
            System.out.println("Маалымат сакталды:");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        try {
            PreparedStatement preparedStatement = Util.connect()
                    .prepareStatement("delete from users where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            System.out.println(id + " Очурулду ");
        } catch (SQLException e) {
            System.out.println("таблица не существует");
        }
    }

    public List<User> getAllUsers() {

        String SQL = "SELECT * FROM users";
        try (Connection connection = Util.connect();
             Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(SQL);
           while (rs.next()) {
               User user = new User();
               user.setId(rs.getLong("id"));
               user.setName(rs.getString("name"));
               user.setLastName(rs.getString("lastName"));
               user.setAge(rs.getByte("age"));
               aiba.add(user);
           }
               System.out.println("опперация ишке ашты:");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aiba;
    }

    public void cleanUsersTable() {
        String SQL = "DELETE FROM users ";
        try (Connection conn = Util.connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(SQL);
            System.out.println("Таблица тазаланды");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}