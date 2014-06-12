import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.edu.pw.elka.pik.issueTracker.IssueController;

/**
 * Created by lucas on 11.06.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/testContext.xml"})
public class IssueControllerTest {
    @Autowired
    ApplicationContext ctx;

    @InjectMocks
    private IssueController issueController;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        // Process mock annotations
//        MockitoAnnotations.initMocks(this);
//
//        // Setup Spring test in standalone mode
//        this.mockMvc = MockMvcBuilders.standaloneSetup(issueController).build();
//    }

    @Test
    public void testShowIssue() {

    }
}
