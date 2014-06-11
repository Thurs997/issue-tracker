package pl.edu.pw.elka.pik.issueTracker.model;

import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

/**
 * Created by lucas on 27.04.14.
 */
@Repository
public class ProjectFacade extends AbstractFacade<Project> {

    public ProjectFacade() {
        super(Project.class);
    }

    public boolean projectExists(String name){
        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<Project> criteria = builder.createQuery(Project.class);
        Root<Project> c = criteria.from(Project.class);
        TypedQuery<Project> query = super.entityManager.createQuery(
                criteria.select(c).where(builder.equal(c.get("name"), name)));
        return query.getResultList().size() > 0;
    }
}