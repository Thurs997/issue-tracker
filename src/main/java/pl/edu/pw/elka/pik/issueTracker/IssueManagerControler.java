package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.pw.elka.pik.issueTracker.model.Issue;
import pl.edu.pw.elka.pik.issueTracker.model.IssueFacade;
import pl.edu.pw.elka.pik.issueTracker.model.Project;
import pl.edu.pw.elka.pik.issueTracker.model.ProjectFacade;

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

        return "ListIssues";
    }

    @RequestMapping(value = "/add-issue", method = RequestMethod.GET)
    public String addIssueForm(Map<String, Object> model) {
        fillUserData(model);
        List<Project> projects = projectFacade.findAll();
        model.put("projects", projects);
        return "AddIssue";
    }

    @RequestMapping(value = "/add-issue", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("issue") Issue issue) {
        issueFacade.create(issue);
        return "redirect:/";
    }
}
