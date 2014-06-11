package pl.edu.pw.elka.pik.issueTracker.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

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
    private String name;
    public enum TYPE {
        BUG,
        ENCHANCEMENT,
        DUPLICATE,
        INVALID
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private TYPE type;

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
