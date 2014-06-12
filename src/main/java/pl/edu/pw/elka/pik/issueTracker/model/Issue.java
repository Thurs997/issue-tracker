package pl.edu.pw.elka.pik.issueTracker.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

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
    private Date lastModified;
    private Integer priority = 0;
    private String assignee;
    private String description;
    private Set<Comment> comments = new LinkedHashSet<Comment>();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
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

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "CREATED", nullable = false)
    public Date getCreated() {
        return created;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
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

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.ALL})
    @JoinColumn(name="ISSUE_ID")
    public Set<Comment> getComments() {
        return comments;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "LAST_MODIFIED")
    public Date getLastModified() {
        return lastModified;
    }

    @PreUpdate
    protected void onUpdate() {
        lastModified = new Date();
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

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    public enum Type {
        BUG("Blad"),
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
        RESOLVED("Rozwiazane"),
        DUPLICATE("Duplikat"),
        WONT_FIX("Nie blad");

        String name;

        public String getName() {
            return name;
        }

        public boolean isOpen(){
            return equals(OPEN) || equals(ON_HOLD) || equals(IN_PROGRESS);
        }

        Status(String name){
            this.name = name;
        }
    }
}
