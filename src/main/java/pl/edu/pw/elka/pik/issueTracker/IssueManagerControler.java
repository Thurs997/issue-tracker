package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.pik.issueTracker.model.*;

import java.util.List;
import java.util.Map;

/**
 * Created by lucas on 11.06.14.
 */
@Controller
public class IssueManagerControler extends AbstractUserDataController {
    @Autowired
    private IssueFacade issueFacade;

    @Autowired
    private ProjectFacade projectFacade;

    @RequestMapping(value="/list-issues", method= RequestMethod.GET)
    public String listIssues(Map<String, Object> model) {
        List<Issue> issues = issueFacade.findAll();
        fillUserData(model);
        model.put("issues", issues);

        return MappingConstant.LIST_ISSUES.toString();
    }

    @RequestMapping(value = "/project/{projectId}/add-issue", method = RequestMethod.GET)
    public String addIssueForm(@PathVariable Long projectId, Map<String, Object> model) {
        fillUserData(model);

        model.put("issue", new Issue());
        model.put("projectId", projectId);
        model.put("issueTypes", Issue.Type.values());
        return MappingConstant.EDIT_ISSUE.toString();
    }
}
