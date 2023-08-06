package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


import teamgen.machine.LotteryMachine;
import teamgen.RepeatingMachine;

@SpringBootApplication
@RestController
public class Demo1Application{

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        LotteryMachine lotterymachine = new LotteryMachine();
        String[] args = {name ,"2"};
        List<List<String>> a = lotterymachine.drawTeam(args);

        return String.format("Hello %s! %s", name,a);
    }
}
