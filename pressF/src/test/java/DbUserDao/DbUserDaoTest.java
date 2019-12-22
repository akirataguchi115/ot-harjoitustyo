package DbUserDao;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import pressf.dao.DbUserDao;
import pressf.domain.User;

/**
 *
 * @author Akira Taguchi
 */
public class DbUserDaoTest {

    private DbUserDao dao;

    @Before
    public void setUp() throws Exception {
        this.dao = new DbUserDao(true);
    }

    @Test
    public void lisaaminenJaLukeminenOnnistuu() throws Exception {
        dao.create(new User("seppo", "salis"));
        assertEquals("seppo", dao.findByUsername("seppo").getUsername());
    }
}
