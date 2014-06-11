package pl.edu.pw.elka.pik.issueTracker.model;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User implements Serializable {
    private Type user;

    public Type getUser() {
        return user;
    }

    public void setUser(Type user) {
        this.user = user;
    }

    public enum Type{
        USER("Użytkownik"), MANAGER("Kierownik"), ADMIN("Administrator");

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