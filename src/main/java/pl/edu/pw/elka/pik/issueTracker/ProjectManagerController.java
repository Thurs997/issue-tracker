package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.pw.elka.pik.issueTracker.model.Project;
import pl.edu.pw.elka.pik.issueTracker.model.ProjectFacade;

import java.util.List;
import java.util.Map;

/**
 * Created by lucas on 27.04.14.
 */
@Controller
public class ProjectManagerController {

    @Autowired
    private ProjectFacade projectFacade;

    @RequestMapping(value="list-projects", method= RequestMethod.GET)
    public String listProjects(Map<String, Object> model) {
        List<Project> projects = projectFacade.findAll();

        //return back to index.jsp
        model.put("projects", projects);

        return "AddProject";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView addProject() {
        return new ModelAndView("AddProject", "project", new Project());
    }

    //@Transactional
    @RequestMapping(value = "add-project", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("Project") Project project, BindingResult bindingResult) {
        return "redirect:list-projects";
    }

}