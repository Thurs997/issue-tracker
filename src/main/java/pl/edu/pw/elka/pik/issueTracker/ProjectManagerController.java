package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.pw.elka.pik.issueTracker.model.*;

import javax.servlet.http.HttpServletRequest;
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
        model.put("project", new Project());
        model.put("projects", projects);
        model.put("availableUsers", User.Type.values());

        return "AddProject";
    }

    @RequestMapping(value = "/add-project", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("project") Project project) {
        projectFacade.create(project);
        return "redirect:/";
    }

}