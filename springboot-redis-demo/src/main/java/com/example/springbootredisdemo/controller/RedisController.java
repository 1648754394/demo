package com.example.springbootredisdemo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootredisdemo.domian.Person;
import com.example.springbootredisdemo.domian.web.Result;
import com.example.springbootredisdemo.domian.web.ResultData;
import com.example.springbootredisdemo.utils.RedisCache;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: RedisController
 * @description:
 * @author: sh.Liu
 * @date: 2022-03-08 14:28
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    private RedisCache redisCache;

    // 4.测试
    @GetMapping("save")
    public Result save(){
        Person person = new Person("John", 30);
        List<Person> people = new ArrayList<>();
        String key = person.getName();
        redisCache.setCacheObject(key, person);
        // 不能直接转换(低版本可以直接转)  估计低版本根据@type自动转换容易有漏洞，高版本不再支持  或使用GenericFastJsonRedisSerializer
        // 或使用自带GenericJackson2JsonRedisSerializer
//        System.out.println(redisCache.getCacheObject(key).toString());
//        System.out.println(redisCache.getCacheObject(key).getClass());
//        Person personResult = redisCache.getCacheObject(key);     //低版本1.2.78
        JSONObject cacheObject = redisCache.getCacheObject(key);
        Person result = cacheObject.toJavaObject(Person.class);

        people.add(person);
        redisCache.setCacheObject("list", people);
        // 数组可以直接转，但取出会报错
        List<Person> personList = redisCache.getCacheObject("list");
//        for (Person person1 : personList) {
//            System.out.println(person1);
//        }
//        Person p1 = personList.get(0);
//        System.out.println(p1);

        JSONArray array = redisCache.getCacheObject("list");
        List<Person> javaList = array.toJavaList(Person.class);
        Person p2 = javaList.get(0);
        System.out.println(p2);
        return new ResultData<>(personList);
    }

}
