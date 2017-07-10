package me.xns.springdemo.controller;

import me.xns.springdemo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xns on 2017/7/10.
 */
@Controller
public class DefaultController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/formtest")
    public String commitForm(Model model) {
        User user = new User();
        user.setName("xns");
        user.setMsg("hello spring");
        model.addAttribute("user", user);
        return "formtest1";
    }

    @RequestMapping("/formtest2")
    public ModelAndView receiveForm(@ModelAttribute("user") User user) {
        logger.info("receiveForm ", "user=" + user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.addObject("message", "it's ok");
        modelAndView.setViewName("formtest2");
        return modelAndView;
    }

}
