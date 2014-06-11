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

    @RequestMapping(value = "/project/{projectId}/add-issue", method = RequestMethod.GET)
    public String addIssueForm(@PathVariable Long projectId, Map<String, Object> model) {
        fillUserData(model);
        Project project = projectFacade.find(projectId);
        Issue issue = new Issue();
        issue.setProject(project);

        model.put("issue", issue);
        model.put("issueTypes", Issue.Type.values());
        return MappingConstant.EDIT_ISSUE.toString();
    }
}
