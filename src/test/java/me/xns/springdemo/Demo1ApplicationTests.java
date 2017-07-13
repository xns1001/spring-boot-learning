package me.xns.springdemo;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.json.JsonGeneratorImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.xns.springdemo.dao.UserMapper;
import me.xns.springdemo.dao.UserRepository;
import me.xns.springdemo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {
    Logger logger = LoggerFactory.getLogger(Demo1Application.class);
    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMybatis() {

    }

    @Test
    public void testUserQuery() {
        List<User> userByMoreThanAge = userMapper.findUserByMoreThanAge(18);
        ObjectMapper objectMapper = new ObjectMapper();
        logger.info("result size=" + userByMoreThanAge.size());
        try {
            JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
            jsonGenerator.writeObject(userByMoreThanAge);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
