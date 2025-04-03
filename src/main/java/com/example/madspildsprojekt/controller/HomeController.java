package com.example.madspildsprojekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    @GetMapping("/")
    public String index()
    {
        return "home/index";
    }

    @GetMapping("privatbruger")
    public String privatbruger()
    {
        return "home/privatbruger";
    }

    @GetMapping("virksomhed")
    public String virksomhed()
    {
        return "home/virksomhed";
    }

    @GetMapping("organisation")
    public String organisation()
    {
        return "home/organisation";
    }
    @GetMapping("opret")
    public String opret()
    {
        return "home/opret";
    }
    @GetMapping("login")
    public String login()
    {
        return "home/login";
    }
    @GetMapping("privatinfo")
    public String privatinfo()
    {
        return "home/privatinfo";
    }
    @GetMapping("opslagstavle")
    public String opslagstavle()
    {
        return "home/opslagstavle";
    }
    @GetMapping("tilmeldevent")
    public String tilmeldevent()
    {
        return "home/tilmeldevent";
    }

}
