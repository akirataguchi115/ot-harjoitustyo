package pressf.dao;

import java.util.List;
import pressf.domain.User;

public interface UserDao {

    /**
     * Creates new user.
     *
     * @param user username
     * @return user that's created
     * @throws Exception due to the handling of files
     */
    User create(User user) throws Exception;

    /**
     * Finds the user passed in the parameter.
     *
     * @param username input as String
     * @return the found user
     */
    User findByUsername(String username);

    /**
     * Returns all users in the list.
     *
     * @return All users
     */
    List<User> getAll();

}
