package pressf.dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import pressf.domain.User;

/**
 *
 * @author Akira Taguchi
 */
public class DbUserDao implements UserDao {

    Properties properties;
    String userDatabase;

    private boolean isTest;

    public DbUserDao(boolean isTest) throws Exception {
        properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        userDatabase = properties.getProperty("userdb");
        initDatabase();
        this.isTest = isTest;
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
        if (isTest) {
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + userDatabase);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
