package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pw.elka.pik.issueTracker.model.User;

import java.util.Map;

@Component
public abstract class AbstractUserDataController {

    @Autowired
    User user;

    protected void fillUserData(Map<String, Object> model){
        model.put("user", user);
        model.put("availableUsers", User.Type.values());
    }

    protected boolean userIsAdmin() {
        return user.isAdmin();
    }

    protected boolean userIsAuthor() {
        return user.isAuthor();
    }


}
