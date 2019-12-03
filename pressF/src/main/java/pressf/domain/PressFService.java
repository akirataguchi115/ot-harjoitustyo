package pressf.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import pressf.dao.UserDao;
import pressf.domain.User;

/**
 * Sovelluslogiikasta vastaava luokka
 */
public class PressFService {

    private UserDao userDao;
    private User loggedIn;

    public PressFService(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Uuden todon lisääminen kirjautuneena olevalle käyttäjälle
     *
     * @param content luotavan todon sisältö
     */
    /**
     * sisäänkirjautuminen
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
     * kirjautuneena oleva käyttäjä
     *
     * @return kirjautuneena oleva käyttäjä
     */
    public User getLoggedUser() {
        return loggedIn;
    }

    /**
     * uloskirjautuminen
     */
    public void logout() {
        loggedIn = null;
    }

    /**
     * uuden käyttäjän luominen
     *
     * @param username käyttäjätunnus
     * @param name käyttäjän nimi
     *
     * @return true jos käyttäjätunnus on luotu onnistuneesti, muuten false
     */
    public boolean createUser(String username,String password) {
        if (userDao.findByUsername(username) != null) {
            return false;
        }
        User user = new User(username, password);
        try {
            userDao.create(user);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
