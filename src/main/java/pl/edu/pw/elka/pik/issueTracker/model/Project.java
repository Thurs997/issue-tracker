package pl.edu.pw.elka.pik.issueTracker.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;
/**
 * Created by lucas on 27.04.14.
 */
@Entity
@Table(name="t_project")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Project implements Serializable {
    private Long id;
    private String name;
    private Set<Issue> issues = new LinkedHashSet<Issue>();

    @OneToMany(fetch = FetchType.EAGER)
    @OrderBy("lastModified DESC")
    @Cascade({CascadeType.ALL})
    @JoinColumn(name="PROJECT_ID")
    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME", unique = true, nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<ProjectStatistics> getStatistics(List<Project> projects) {
        List<ProjectStatistics> stats = new ArrayList<ProjectStatistics>();
        for(Project project : projects){
            stats.add(project.countStatistics());
        }
        return stats;
    }

    private ProjectStatistics countStatistics() {
        ProjectStatistics stats = new ProjectStatistics();
        stats.setIssues(issues.size());
        Date lastCreated = new Date(0);
        Date lastModified = new Date(0);
        int openIssues = 0;

        for(Issue issue : issues){
            if(issue.getStatus().isOpen())
                openIssues++;
            if(issue.getCreated().after(lastCreated))
                lastCreated = issue.getCreated();
            if(issue.getLastModified().after(lastModified))
                lastModified = issue.getLastModified();
        }

        stats.setOpenIssues(openIssues);
        if(lastCreated.getTime() != 0)
            stats.setLastIssue(lastCreated);
        if(lastModified.getTime() != 0)
        stats.setLastChange(lastModified);
        return stats;
    }
}
