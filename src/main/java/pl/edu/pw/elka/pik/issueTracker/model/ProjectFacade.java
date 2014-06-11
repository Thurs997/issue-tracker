package pl.edu.pw.elka.pik.issueTracker.model;

import org.springframework.stereotype.Repository;
import pl.edu.pw.elka.pik.issueTracker.AbstractFacade;

/**
 * Created by lucas on 27.04.14.
 */
@Repository
public class ProjectFacade extends AbstractFacade<Project> {

    public ProjectFacade() {
        super(Project.class);
    }

//    @Override
//    public Project find(Long primaryKey) {
//        Project p = super.find(primaryKey);
//        p.getIssues();
//        return p;
//    }

}