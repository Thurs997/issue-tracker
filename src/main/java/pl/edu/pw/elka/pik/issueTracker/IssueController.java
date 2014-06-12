package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.pik.issueTracker.model.*;

import java.util.*;

/**
 * Created by lucas on 11.06.14.
 */
@Controller
public class IssueController extends AbstractUserDataController {

    @Autowired
    private IssueFacade issueFacade;
    @Autowired
    private CommentFacade commentFacade;
    @Autowired
    private ProjectFacade projectFacade;

    @RequestMapping(value = "/show-issue/{issueId}", method = RequestMethod.GET)
    public String showIssue(@PathVariable long issueId, Map<String, Object> model) {
        Issue issue = issueFacade.find(issueId);
        List<Comment> comments = commentFacade.getCommentsByIssueId(issueId);
        model.put("issue", issue);
        model.put("comments", comments);
        model.put("comment", new Comment());
        fillUserData(model);
        return MappingConstant.SHOW_ISSUE.toString();
    }

    @RequestMapping(value = "/edit-issue/{issueId}", method = RequestMethod.GET)
    public String editIssue(@PathVariable long issueId, Map<String, Object> model) {
        if(!userIsManager()) {
            return "Unauthorized";
        }
        Issue issue = issueFacade.find(issueId);
        model.put("issue", issue);
        model.put("projectId", issue.getProject().getId());
        model.put("issueTypes", Issue.Type.values());
        fillUserData(model);
        return MappingConstant.EDIT_ISSUE.toString();
    }

    @RequestMapping(value = "/project/{projectId}/edit-issue", method = RequestMethod.POST)
    public String saveIssue(@PathVariable Long projectId, @ModelAttribute("issue") Issue issue) {
        if(issue.getId() == null){
            Project project = projectFacade.find(projectId);
            issue.setStatus(Issue.Status.OPEN);
            issue.setCreated(new Date());
            issue.setProject(project);
            issueFacade.create(issue);

        } else{
            Issue dbIssue = issueFacade.find(issue.getId());
            dbIssue.setName(issue.getName());
            dbIssue.setAssignee(issue.getAssignee());
            dbIssue.setDescription(issue.getDescription());
            dbIssue.setType(issue.getType());
            dbIssue.setPriority(issue.getPriority());
            issueFacade.edit(dbIssue);
        }
        return "redirect:/show-issue/"+issue.getId();
    }

    @RequestMapping(value = "/issue/{issueId}/add-comment", method = RequestMethod.POST)
    public String addComment(@PathVariable Long issueId, @ModelAttribute("comment") Comment comment){
        comment.setTime(new Date());
        Issue issue = issueFacade.find(issueId);
        issue.getComments().add(comment);
        issueFacade.edit(issue);
        return "redirect:/show-issue/"+issueId;
    }
}
