package pressf.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import pressf.dao.DbUserDao;
import pressf.dao.UserDao;
import pressf.domain.User;

public class PressFService {

    private DbUserDao userDao;
    private User loggedIn;

    /**
     * Constructor for PressFService.
     *
     * @param userDao userDao object given as parameter
     */
    public PressFService(DbUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * sisäänkirjautuminen.
     *
     * @param username käyttäjätunnus
     *
     * @return true jos käyttäjätunnus on olemassa, muuten false
     */
    public boolean login(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        }

        loggedIn = user;

        return true;
    }

    /**
     * kirjautuneena oleva käyttäjä.
     *
     * @return kirjautuneena oleva käyttäjä
     */
    public User getLoggedUser() {
        return userDao.findByUsername(loggedIn.getUsername());
    }

    /**
     * uloskirjautuminen.
     */
    public void logout() {
        loggedIn = null;
    }

    /**
     * uuden käyttäjän luominen.
     *
     * @param username käyttäjätunnus
     * @param password password
     *
     * @return true jos käyttäjätunnus on luotu onnistuneesti, muuten false
     */
    public boolean createUser(String username, String password) {
//        if (userDao.findByUsername(username) != null) {
//            System.out.println("User already defined");
//            return false;
//        }
//        if (password.length() < 4) {
//            System.out.println("Password too short");
//            return false;
//        }
        User user = new User(username, password);
        this.loggedIn = user;
        try {
            userDao.create(user);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
