package pl.edu.pw.elka.pik.issueTracker.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by lucas on 11.06.14.
 */
@Entity
@Table(name="t_issue")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Issue {
    private Integer id;
    private String name;
    private Type type;
    private Date created;
    private Date completed;
    private Integer priority = 0;
    private String assignee;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    @Column(name = "NAME", unique = true, nullable = false, length = 40)
    public String getName() {
        return name;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    public Type getType() {
        return type;
    }

    @Column(name = "CREATED", nullable = false)
    public Date getCreated() {
        return created;
    }

    @Column(name = "COMPLETED", nullable = true)
    public Date getCompleted() {
        return completed;
    }

    @Column(name = "PRIORITY", nullable = false)
    public Integer getPriority() {
        return priority;
    }

    @Column(name = "ASSIGNEE", nullable = true, length = 40)
    public String getAssignee() {
        return assignee;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public enum Type {
        BUG,
        ENHANCEMENT,
        DUPLICATE,
        INVALID
    }
}
