package pl.edu.pw.elka.pik.issueTracker.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;
/**
 * Created by lucas on 27.04.14.
 */
@Entity
@Table(name="t_project")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Project implements Serializable {
    private Integer id;
    private String name;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
