package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.pik.issueTracker.model.Project;
import pl.edu.pw.elka.pik.issueTracker.model.ProjectFacade;

import java.util.Map;

/**
 * Created by lucas on 11.06.14.
 */
@Controller
public class ProjectController extends AbstractUserDataController {
    @Autowired
    private ProjectFacade projectFacade;

    @RequestMapping(value = "/show-project/{projectId}",  method = RequestMethod.GET)
    public String showProject(@PathVariable long projectId, Map<String, Object> model) {
        Project project = projectFacade.find(projectId);
        fillUserData(model);
        model.put("project", project);
        return MappingConstant.SHOW_PROJECT.toString();
    }
    @RequestMapping(value = "/manage-project/{projectId}",  method = RequestMethod.GET)
    public String manageProject (@PathVariable long projectId, Map<String, Object> model) {
        if(!user.isAuthor()) {
            return MappingConstant.UNAUTHORIZED.toString();
        }
        Project project = projectFacade.find(projectId);
        fillUserData(model);
        model.put("project", project);
        return MappingConstant.MANAGE_PROJECT.toString();

    }

    @RequestMapping(value = "/manage-project", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("project") Project project) {
        Project dbProject = projectFacade.find(project.getId());
        dbProject.setName(project.getName());
        projectFacade.edit(dbProject);
        return MappingConstant.REDIRECT_ROOT.toString();
    }
}
