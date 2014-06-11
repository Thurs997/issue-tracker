package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.elka.pik.issueTracker.model.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    User user;

    @RequestMapping(value = "/change-user", method = RequestMethod.POST)
    public String changeUser(@ModelAttribute("user") User user, HttpServletRequest request) {
        this.user.setUser(user.getUser());
        String referer = request.getHeader("Referer");
        if(referer == null)
            referer = "/";
        return "redirect:"+referer;
    }
}
