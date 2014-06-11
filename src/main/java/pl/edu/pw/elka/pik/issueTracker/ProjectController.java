package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pw.elka.pik.issueTracker.model.*;

import java.util.Map;

/**
 * Created by lucas on 11.06.14.
 */
@Controller
public class ProjectController extends AbstractUserDataController {
    @Autowired
    private ProjectFacade projectFacade;

    @RequestMapping(value = "/show-project",  method = RequestMethod.GET)
    public String showProject(@RequestParam long projectId, Map<String, Object> model) {
        Project project = projectFacade.find(projectId);
        fillUserData(model);
        model.put("project", project);
        return MappingConstant.SHOW_PROJECT.toString();
    }
    @RequestMapping(value = "/manage-project",  method = RequestMethod.GET)
    public String manageProject (@RequestParam long projectId, Map<String, Object> model) {
        if(!user.isManager()) {
            return MappingConstant.UNAUTHORIZED.toString();
        }
        Project project = projectFacade.find(projectId);
        fillUserData(model);
        model.put("project", project);
        return MappingConstant.MANAGE_PROJECT.toString();

    }
}
