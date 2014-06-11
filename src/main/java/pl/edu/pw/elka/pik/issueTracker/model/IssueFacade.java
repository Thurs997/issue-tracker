package pl.edu.pw.elka.pik.issueTracker.model;

import org.springframework.stereotype.Repository;
import pl.edu.pw.elka.pik.issueTracker.AbstractFacade;

/**
 * Created by lucas on 11.06.14.
 */
@Repository
public class IssueFacade extends AbstractFacade<Issue> {
    public IssueFacade() {
        super(Issue.class);
    }
}
