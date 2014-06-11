package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pw.elka.pik.issueTracker.model.Project;
import pl.edu.pw.elka.pik.issueTracker.model.ProjectFacade;
import pl.edu.pw.elka.pik.issueTracker.model.User;

import java.util.Map;

/**
 * Created by lucas on 11.06.14.
 */
@Controller
public class ProjectController {
    @Autowired
    private ProjectFacade projectFacade;

    @Autowired
    private User user;

    @RequestMapping(value = "/show-project",  method = RequestMethod.GET)
    public String showProject(@RequestParam long projectId, Map<String, Object> model) {
        Project project = projectFacade.find(projectId);
        model.put("project", project);
        model.put("user", user);
        model.put("availableUsers", User.Type.values());
        return "ShowProject";
    }
    @RequestMapping(value = "/manage-project",  method = RequestMethod.GET)
    public String manageProject (@RequestParam long projectId, Map<String, Object> model) {
        if(user.getUser() == User.Type.USER) {
            return "Unauthorized";
        }
        Project project = projectFacade.find(projectId);
        model.put("project", project);
        model.put("user", user);
        model.put("availableUsers", User.Type.values());
        return "ManageProject";

    }
}
