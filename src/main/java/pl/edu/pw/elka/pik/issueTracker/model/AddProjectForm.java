package pl.edu.pw.elka.pik.issueTracker.model;

import java.io.Serializable;

/**
 * Created by lucas on 27.04.14.
 */
public class AddProjectForm implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
