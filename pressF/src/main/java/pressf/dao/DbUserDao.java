/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pressf.dao;

import java.sql.*;
import java.util.List;
import pressf.domain.User;

/**
 *
 * @author Akira Taguchi
 */
public class DbUserDao implements UserDao {

    public DbUserDao() {
        initDatabase();
    }

    @Override
    public User create(User user) throws Exception {
        Connection connection = connect();
        try {
            PreparedStatement stmt = connection.
                    prepareStatement("INSERT INTO User(name, password)" + "VALUES(?,?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPwrd());

            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("perkele :" + ex.getMessage());
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        String un = null;
        String pw = null;
        try {
            PreparedStatement stmt = connect().prepareStatement("SELECT name,password FROM User WHERE name == ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            un = rs.getString("name");
            pw = rs.getString("password");
            System.out.println("Welcome: " + un);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return new User(un, pw);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    public void initDatabase() {
        try {
            Connection connection = connect();
            PreparedStatement stmt = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS User(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(100), password VARCHAR(100));"
            );
            stmt.execute();
            stmt.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("aaaaaaaaaaaaaahhh: " + ex.getMessage());
        }
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:users.db");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
