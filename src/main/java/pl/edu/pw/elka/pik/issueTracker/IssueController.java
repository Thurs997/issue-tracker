package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pw.elka.pik.issueTracker.model.Issue;
import pl.edu.pw.elka.pik.issueTracker.model.IssueFacade;

import java.util.Map;

/**
 * Created by lucas on 11.06.14.
 */
@Controller
public class IssueController extends AbstractUserDataController {

    @Autowired
    private IssueFacade issueFacade;

    @RequestMapping(value = "/show-issue", method = RequestMethod.GET)
    public String showIssue(@RequestParam long issueId, Map<String, Object> model) {
        Issue issue = issueFacade.find(issueId);
        model.put("issue", issue);
        fillUserData(model);
        return MappingConstant.SHOW_ISSUE.toString();
    }

    @RequestMapping(value = "/edit-issue", method = RequestMethod.GET)
    public String editIssue(@RequestParam long issueId, Map<String, Object> model) {
        if(!userIsManager()) {
            return "Unauthorized";
        }
        Issue issue = issueFacade.find(issueId);
        model.put("issue", issue);
        fillUserData(model);
        return MappingConstant.EDIT_ISSUE.toString();
    }
}
