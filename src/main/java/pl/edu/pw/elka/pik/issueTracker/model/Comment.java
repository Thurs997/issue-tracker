package pl.edu.pw.elka.pik.issueTracker.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="t_comment")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Comment {
    private Long id;
    private String author;
    private Date time;
    private String content;
    private Issue issue;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name = "AUTHOR", unique = false, nullable = false, length = 40)
    public String getAuthor() {
        return author;
    }

    @Column(name = "TIME", unique = false, nullable = false)
    public Date getTime() {
        return time;
    }

    @Column(name = "CONTENT", unique = false, nullable = false, length = 400)
    public String getContent() {
        return content;
    }

    @ManyToOne
    @Cascade({CascadeType.MERGE, CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "ISSUE_ID")
    public Issue getIssue() {
        return issue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }
    @PrePersist
    protected void onCreate() {
        time = new Date();
    }

}
