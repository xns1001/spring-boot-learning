package me.xns.springdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class DefaultController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LearnService learnService;

    @Autowired
    UserRepository userRepository;


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

    @PostMapping("/user")
    @ResponseBody
    public User addUser(@RequestParam("name") String name,
                        @RequestParam(value = "age", required = false) Integer age,
                        @RequestParam(value = "desc", required = false, defaultValue = "") String desc) {
        User user = new User();
        user.setName(name);
        if (age != null) {
            user.setAge(age);
        }
        user.setDesc(desc);
        User save = userRepository.save(user);
        return save;
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") Integer id) {
        User one = userRepository.findOne(id);
        return one;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUser() {
        List<User> all = userRepository.findAll();
        return all;
    }

    @PutMapping("/user/{id}")
    @ResponseBody
    public User updateUser(@PathVariable("id") Integer id,
                           @RequestParam(required = true, name = "name") String name,
                           @RequestParam(required = true, name = "desc") String desc) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDesc(desc);
        User save = userRepository.save(user);
        return save;
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public User deleteUser(@PathVariable("id") Integer id) {
        User one = userRepository.findOne(id);
        userRepository.delete(id);
        return one;
    }


}
