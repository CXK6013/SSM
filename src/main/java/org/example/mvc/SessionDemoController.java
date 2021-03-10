package org.example.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author XingKe
 * @date 2021-03-09 10:48
 */
@Controller
@SessionAttributes(value = "password")
public class SessionDemoController {

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public String testGet(@RequestParam(value = "name") String userName, @RequestParam(value = "password") String password ,Model model) {
        System.out.println("username:" + userName);
        System.out.println("password:" + password);
        model.addAttribute("password",password);
        return "success";
    }
}
