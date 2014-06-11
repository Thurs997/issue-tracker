package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.pik.issueTracker.model.Issue;
import pl.edu.pw.elka.pik.issueTracker.model.IssueFacade;

import java.util.Date;
import java.util.Map;

/**
 * Created by lucas on 11.06.14.
 */
@Controller
public class IssueController extends AbstractUserDataController {

    @Autowired
    private IssueFacade issueFacade;

    @RequestMapping(value = "/show-issue/{issueId}", method = RequestMethod.GET)
    public String showIssue(@PathVariable long issueId, Map<String, Object> model) {
        Issue issue = issueFacade.find(issueId);
        model.put("issue", issue);
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
        model.put("issueTypes", Issue.Type.values());
        fillUserData(model);
        return MappingConstant.EDIT_ISSUE.toString();
    }

    @RequestMapping(value = "/edit-issue", method = RequestMethod.POST)
    public String saveIssue(@ModelAttribute("issue") Issue issue) {
        if(issue.getId() == null){
            issue.setCreated(new Date());
            issue.setStatus(Issue.Status.OPEN);
            issueFacade.create(issue);
        } else
            issueFacade.edit(issue);
        return "redirect:/show-issue/"+issue.getId();
    }
}
