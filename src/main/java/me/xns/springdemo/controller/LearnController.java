package me.xns.springdemo.controller;

import me.xns.springdemo.dao.UserRepository;
import me.xns.springdemo.domain.LearnResouce;
import me.xns.springdemo.domain.User;
import me.xns.springdemo.service.LearnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xns on 2017/7/10.
 */
@Controller
@RequestMapping("/learn")
public class LearnController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LearnService learnService;


    @RequestMapping("/formtest")
    public String commitForm(Model model) {
        User user = new User();
        user.setName("xns");
        user.setDesc("hello spring");
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

    @RequestMapping("/queryDb")
    @ResponseBody
    public List<LearnResouce> queryDb() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", 1);
        map.put("rows", 4);
        map.put("author", "");
        map.put("title", "");
        List<LearnResouce> learnResouces = learnService.queryLearnResouceList(map);
        if (learnResouces != null) {
            for (LearnResouce resouce : learnResouces) {
                logger.info(resouce.toString());
            }
        }
        return learnResouces;
    }

}
