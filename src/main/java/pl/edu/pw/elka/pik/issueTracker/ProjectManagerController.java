package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.pik.issueTracker.model.*;

import java.util.List;
import java.util.Map;

/**
 * Created by lucas on 27.04.14.
 */
@Controller
public class ProjectManagerController {

    @Autowired
    private ProjectFacade projectFacade;
    @Autowired
    private User user;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String listProjects(Map<String, Object> model) {
        List<Project> projects = projectFacade.findAll();

        model.put("user", user);
        model.put("availableUsers", User.Type.values());
        model.put("projects", projects);

        return "ListProjects";
    }

    @RequestMapping(value = "/add-project", method = RequestMethod.GET)
    public String addProjectForm(Map<String, Object> model) {

        model.put("user", user);
        model.put("project", new Project());
        model.put("availableUsers", User.Type.values());

        return "AddProject";
    }

    @RequestMapping(value = "/add-project", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("project") Project project) {
        projectFacade.create(project);
        return "redirect:/";
    }

}