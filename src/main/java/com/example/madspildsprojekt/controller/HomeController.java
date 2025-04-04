package com.example.madspildsprojekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// Merry er en fukin gedehams
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

    @GetMapping("login")
    public String login()
    {
        return "home/login";
    }

    @GetMapping("opret")
    public String opret()
    {
        return "home/opret";
    }

    @GetMapping("privatinfo")
    public String privatinfo()
    {
        return "home/privatinfo";
    }

    @GetMapping("organisationinfo")
    public String organisationinfo()
    {
        return "home/organisationinfo";
    }

    @GetMapping("virksomhedinfo")
    public String virksomhedinfo()
    {
        return "home/virksomhedinfo";
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

    @GetMapping("opretopslag")
    public String opretopslag()
    {
        return "home/opretopslag";
    }
}
