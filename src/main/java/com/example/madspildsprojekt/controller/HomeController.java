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
}
