package pl.edu.pw.elka.pik.issueTracker.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User implements Serializable {
    private Type user = Type.USER;

    public Type getUser() {
        return user;
    }

    public void setUser(Type user) {
        this.user = user;
    }

    public boolean isAuthor(){
        return user.equals(Type.AUTHOR) || user.equals(Type.ADMIN);
    }

    public boolean isAdmin(){
        return user.equals(Type.ADMIN);
    }

    public enum Type{
        USER("Uzytkownik"), AUTHOR("Autor"), ADMIN("Administrator");

        private String label;

        Type(String label){
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }
}
