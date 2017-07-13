package me.xns.springdemo.dao;

import me.xns.springdemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by xns on 2017/7/12.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
