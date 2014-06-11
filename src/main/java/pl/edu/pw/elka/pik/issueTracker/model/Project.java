package pl.edu.pw.elka.pik.issueTracker.model;

import org.hibernate.FetchMode;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    private List<Issue> issues;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.ALL})
    @JoinColumn(name="PROJECT_ID")
    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
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

}
