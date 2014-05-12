package pl.edu.pw.elka.pik.issueTracker;

/**
 * Created by lucas on 27.04.14.
 */
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractFacade<T> {

    @PersistenceContext(unitName = "issue-tracker")
    private EntityManager entityManager;

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstractFacade() {
    }

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Transactional
    public void create(T entity) {
        this.entityManager.persist(entity);
    }

    public void edit(T entity) {
        this.entityManager.merge(entity);
    }

    public void remove(T entity) {
        this.entityManager.remove(this.entityManager.merge(entity));
    }

    public T find(Long primaryKey) {
        return this.entityManager.find(entityClass, primaryKey);
    }

    public List<T> findAll() {
        CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return this.entityManager.createQuery(cq).getResultList();
    }

}