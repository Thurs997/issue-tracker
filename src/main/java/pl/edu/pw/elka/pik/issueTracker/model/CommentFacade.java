package pl.edu.pw.elka.pik.issueTracker.model;

import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class CommentFacade extends AbstractFacade<Comment> {

    CommentFacade(){
        super(Comment.class);
    }

    public List<Comment> getCommentsByIssueId(Long issueId){
        CriteriaBuilder builder = super.entityManager.getCriteriaBuilder();
        CriteriaQuery<Comment> criteria = builder.createQuery(Comment.class);
        Root<Comment> c = criteria.from(Comment.class);
        TypedQuery<Comment> query = super.entityManager.createQuery(
                criteria.select(c).where(builder.equal(c.get("issue").get("id"), issueId)));
        return query.getResultList();
    }

}
