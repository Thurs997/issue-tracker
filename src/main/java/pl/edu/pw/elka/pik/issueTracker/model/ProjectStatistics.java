package pl.edu.pw.elka.pik.issueTracker.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ProjectStatistics {
    int issues;
    int openIssues;
    Date lastIssue;
    Date lastChange;

    public int getIssues() {
        return issues;
    }

    public void setIssues(int issues) {
        this.issues = issues;
    }

    public int getOpenIssues() {
        return openIssues;
    }

    public void setOpenIssues(int openIssues) {
        this.openIssues = openIssues;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public Date getLastIssue() {
        return lastIssue;
    }

    public void setLastIssue(Date lastIssue) {
        this.lastIssue = lastIssue;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }
}
