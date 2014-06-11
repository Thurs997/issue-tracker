import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.pw.elka.pik.issueTracker.model.Comment;
import pl.edu.pw.elka.pik.issueTracker.model.CommentFacade;
import pl.edu.pw.elka.pik.issueTracker.model.Issue;
import pl.edu.pw.elka.pik.issueTracker.model.IssueFacade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by lucas on 11.06.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/testContext.xml"})
public class CommentFacadeTest {

    CommentFacade commentFacade;
    IssueFacade issueFacade;
    @Autowired
    ApplicationContext ctx;

    @Before
    public void setUp() {
        commentFacade = ctx.getAutowireCapableBeanFactory().createBean(CommentFacade.class);
        issueFacade = ctx.getAutowireCapableBeanFactory().createBean(IssueFacade.class);
    }

    @Test
    public void testGettingByIssueId() {
        Issue issue = new Issue();
        issue.setName("name");
        issue.setType(Issue.Type.BUG);
        issue.setCreated(new Date());
        issue.setPriority(0);
        Comment comment = new Comment();
        comment.setAuthor("author");
        Date creationDate = new Date();
        comment.setTime(creationDate);
        comment.setContent("abc");
        List<Comment> comments = new ArrayList<Comment>(){};
        comments.add(comment);

        issue.setComments(comments);

        issueFacade.create(issue);
        assertTrue(issue.getId() == 1L);
        List<Comment> retrieved = commentFacade.getCommentsByIssueId(1L);
        assertTrue(retrieved.size() == 1);
        Comment retrievedComment = retrieved.get(0);
        assertTrue(retrievedComment.getId() == 1L);
        assertTrue(retrievedComment.getAuthor().equals("author"));
        assertTrue(retrievedComment.getTime().getTime() == creationDate.getTime());
        assertTrue(retrievedComment.getContent().equals("abc"));
        assertTrue(retrievedComment.getIssue().getId() == 1L);
    }


}
