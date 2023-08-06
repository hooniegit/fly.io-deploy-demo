package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import teamgen.machine.LotteryMachine;
import teamgen.AppDbcp;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           @RequestParam(name="teamMember") String teamMember,
//                           @RequestParam(name="")
                           Model model) {
        String[] args = {name, "3"};
        int thread = 100;
        int draw = 10000;
        LotteryMachine lm = new LotteryMachine();
        List<List<String>> teams = lm.unionDrawTeam(args, draw);
        List<Integer> n = new ArrayList<>();
        AppDbcp ad = new AppDbcp(thread,draw);
        ResultSet select_result = ad.selectDB(teamMember);
        model.addAttribute("teams", teams);
        model.addAttribute("teamMember",select_result);
        return "greeting";
    }
    @GetMapping("/team")
    public String select(@RequestParam("teamMember") String teamMember, Model model) {
        model.addAttribute("teamMember", teamMember);

        return "result";
    }
}