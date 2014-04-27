package pl.edu.pw.elka.pik.issueTracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kokoss on 4/27/14.
 */
@Controller
public class MainController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String testSite(){
        return "HelloWorld";
    }

}
