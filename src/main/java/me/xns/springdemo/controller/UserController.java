package me.xns.springdemo.controller;

import me.xns.springdemo.dao.UserRepository;
import me.xns.springdemo.domain.Result;
import me.xns.springdemo.domain.User;
import me.xns.springdemo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by xns on 2017/7/13.
 */
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;


    @PostMapping("/user")
    public Result<User> addUser(@Valid User user) {
        User save = userRepository.save(user);
        return ResultUtil.success(save);
    }

    @GetMapping("/user/{id}")
    public Result<User> getUser(@PathVariable("id") Integer id) {
        User one = userRepository.findOne(id);
        return ResultUtil.success(one);
    }

    @GetMapping("/users")
    public Result<List<User>> getAllUser() {
        List<User> all = userRepository.findAll();
        return ResultUtil.success(all);
    }

    @PutMapping("/user/{id}")
    public Result<User> updateUser(@PathVariable("id") Integer id,
                                   @RequestParam(required = true, name = "name") String name,
                                   @RequestParam(required = true, name = "desc") String desc) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDesc(desc);
        User save = userRepository.save(user);
        return ResultUtil.success(save);
    }

    @DeleteMapping("/user/{id}")
    public Result<User> deleteUser(@PathVariable("id") Integer id) {
        User one = userRepository.findOne(id);
        userRepository.delete(id);
        return ResultUtil.success(one);
    }
}
