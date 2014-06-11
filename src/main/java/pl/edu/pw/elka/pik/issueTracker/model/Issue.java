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
    private Status status;
    private String name;
    private Type type;
    private Date created;
    private Date completed;
    private Integer priority = 0;
    private String assignee;
    private String description;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    public Status getStatus() {
        return status;
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

    @Column(name = "DESCRIPTION", nullable = false, length = 1000)
    public String getDescription() {
        return description;
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

    public void setStatus(Status status) {
        this.status = status;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public enum Type {
        BUG("Błąd"),
        ENHANCEMENT("Usprawnienie");

        String name;

        public String getName() {
            return name;
        }

        Type(String name){
            this.name = name;
        }
    }

    public enum Status {
        OPEN("Otwarte"),
        ON_HOLD("Wstrzymane"),
        IN_PROGRESS("W toku"),
        RESOLVED("Rozwiązane"),
        DUPLICATE("Duplikat"),
        WONT_FIX("Nie błąd");

        String name;

        public String getName() {
            return name;
        }

        Status(String name){
            this.name = name;
        }
    }
}
