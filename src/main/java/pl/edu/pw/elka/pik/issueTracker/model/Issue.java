package pl.edu.pw.elka.pik.issueTracker.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by lucas on 11.06.14.
 */
@Entity
@Table(name="t_issue")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Issue {
    private Long id;
    private Project project;
    private String name;
    private Type type;
    private Date created;
    private Date completed;
    private Integer priority = 0;
    private String assignee;
    private List<Comment> comments;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @ManyToOne
    @Cascade({CascadeType.MERGE, CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "PROJECT_ID")
    public Project getProject() {
        return project;
    }

    @Column(name = "NAME", unique = false, nullable = false, length = 40)
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

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade({CascadeType.ALL})
    @JoinColumn(name="ISSUE_ID")
    public List<Comment> getComments() {
        return comments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProject(Project project) {
        this.project = project;
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

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public enum Type {
        BUG,
        ENHANCEMENT,
        DUPLICATE,
        INVALID
    }
}
