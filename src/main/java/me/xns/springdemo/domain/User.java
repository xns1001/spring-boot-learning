package me.xns.springdemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * Created by xns on 2017/7/10.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "名字不能为空")
    @Column(name = "username")
    private String name;

    @Max(value = 120, message = "年龄不能超过120")
    @Column(name = "age")
    private Integer age;

    @Column(name = "description")   //desc为mysql关键词,不能用!!!
    private String desc;

    public User() {

    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                '}';
    }
}
