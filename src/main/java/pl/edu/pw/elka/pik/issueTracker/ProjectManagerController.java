package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.pw.elka.pik.issueTracker.model.AddProjectForm;
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

    @RequestMapping(value="index/list-projects", method= RequestMethod.GET)
    public String listProjects(Map<String, Object> model) {
        List<Project> projects = projectFacade.findAll();

        //return back to index.jsp
        model.put("projects", projects);

        return "index";
    }

    @Transactional
    @RequestMapping(value = "index", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("index") AddProjectForm form) {
        Project project = new Project();
        project.setName(form.getName());
        projectFacade.create(project);
        return "index";
    }

}