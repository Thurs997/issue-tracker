import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.pw.elka.pik.issueTracker.model.*;

import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by lucas on 11.06.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/testContext.xml"})
public class FacadeTest {
    private CommentFacade commentFacade;
    private ProjectFacade projectFacade;
    private IssueFacade issueFacade;
    @Autowired
    ApplicationContext ctx;

    @Before
    public void setUp() {
        projectFacade = ctx.getAutowireCapableBeanFactory().createBean(ProjectFacade.class);
    }

    @Test
    public void testFacadeWiring() {
        commentFacade = ctx.getAutowireCapableBeanFactory().createBean(CommentFacade.class);
        issueFacade = ctx.getAutowireCapableBeanFactory().createBean(IssueFacade.class);
        assertNotNull(commentFacade);
        assertNotNull(issueFacade);
        assertNotNull(projectFacade);
    }

    @Test
    public void testCreate() {
        Project project = new Project();
        project.setName("name");
        projectFacade.create(project);
        assertTrue(project.getId() == 1L);
    }

    @Test
    public void testFindAndFindAll() {
        Project project = projectFacade.find(1L);
        assertNotNull(project);
        assertTrue(project.getId() == 1L);
        assertTrue(project.getName().equals("name"));
        List<Project> projects = projectFacade.findAll();
        assertTrue(projects.size() == 1);
        Project fromList = projects.get(0);
        assertTrue(fromList.getId() == 1L);
        assertTrue(fromList.getName().equals("name"));
    }

    @Test
    public void testRemove() {
        Project project = projectFacade.find(1L);
        projectFacade.remove(project);
        assertTrue(projectFacade.findAll().size() == 0);
        assertNull(projectFacade.find(1L));
    }

    @Test
    public void testEdit() {
        Project project = new Project();
        project.setName("name");
        projectFacade.create(project);
        assertTrue(project.getId() == 2L);
        project.setName("otherName");
        projectFacade.edit(project);
        assertTrue(projectFacade.findAll().size() == 1);
        Project modifiedFound = projectFacade.find(2L);
        assertTrue(modifiedFound.getId() == 2L);
        assertTrue(modifiedFound.getName().equals("otherName"));
    }

}
