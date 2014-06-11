package pl.edu.pw.elka.pik.issueTracker.model;

import org.springframework.stereotype.Repository;

/**
 * Created by lucas on 27.04.14.
 */
@Repository
public class ProjectFacade extends AbstractFacade<Project> {

    public ProjectFacade() {
        super(Project.class);
    }

}