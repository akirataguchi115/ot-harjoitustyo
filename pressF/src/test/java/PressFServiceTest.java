
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import pressf.dao.FileUserDao;
import pressf.domain.PressFService;
import static org.junit.Assert.*;

/**
 *
 * @author Akira Taguchi
 */
public class PressFServiceTest {

    PressFService p;
    File file;

    @Before
    public void setUp() throws FileNotFoundException, IOException, Exception {
        this.file = new File("testfile.txt");
        FileUserDao userDao = new FileUserDao("testfile.txt");
        this.p = new PressFService(null);
        FileWriter fw = new FileWriter(this.file, false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("test;mrboi\n");
        bw.flush();
        bw.close();
    }

    @Test
    public void alreadyDefined() throws IOException {
        assertFalse(this.p.createUser("test", "smthng"));
    }

    @Test
    public void passwordTooShort() {
        assertFalse(this.p.createUser("new", "123"));
    }
}
