package pl.edu.pw.elka.pik.issueTracker;

public enum MappingConstant {

    UNAUTHORIZED("Unauthorized"),

    REDIRECT_ROOT("redirect:/"),
    REDIRECT_LIST_ISSUES("redirect:/list-issues"),

    LIST_PROJECTS("ListProjects"),
    SHOW_PROJECT("ShowProject"),
    MANAGE_PROJECT("ManageProject"),
    ADD_PROJECT("AddProject"),

    EDIT_ISSUE("EditIssue"),
    SHOW_ISSUE("ShowIssue");

    private String mapping;

    MappingConstant(String mapping){
        this.mapping = mapping;
    }

    @Override
    public String toString() {
        return mapping;
    }
}
