import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.pw.elka.pik.issueTracker.model.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by lucas on 11.06.14.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"/testContext.xml"})
public class UserTest {
    @Test
    public void testUser() {
        User user = new User();
        user.setUser(User.Type.USER);
        assertFalse(user.isAdmin());
        assertFalse(user.isManager());
        user.setUser(User.Type.ADMIN);
        assertTrue(user.isManager());
    }

    @Test
    public void testUserType() {
        User.Type type = User.Type.USER;
        type.setLabel("xx");
        assertTrue(type.getLabel().equals("xx"));
    }
}
