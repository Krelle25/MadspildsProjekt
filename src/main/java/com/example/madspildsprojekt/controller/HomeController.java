package com.example.madspildsprojekt.controller;
/*test*/
import com.example.madspildsprojekt.model.Bruger;
import com.example.madspildsprojekt.model.BrugerForm;
import com.example.madspildsprojekt.service.BrugerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController
{
    @Autowired
    private BrugerService brugerService;

    @GetMapping("/")
    public String index()
    {
        return "home/index";
    }

    @GetMapping("login")
    public String login(HttpSession session)
    {
        if (Boolean.TRUE.equals(session.getAttribute("loggedIn")))
        {
            return "redirect:/";
        }
        return "home/login";
    }

    @PostMapping("login")
    public String processLogin(BrugerForm form, HttpSession session, Model model)
    {
        Bruger bruger = brugerService.findBruger(form.getBrugernavn(), form.getAdgangskode());

        if (bruger != null)
        {
            session.setAttribute("loggedIn", true);
            session.setAttribute("brugerType", bruger.getRolle());
            session.setAttribute("brugernavn", bruger.getBrugernavn());

            return "redirect:/" + bruger.getRolle();
        } else {
            model.addAttribute("besked", "Forkert brugernavn eller adgangskode.");
            return "home/login";
        }
    }

    @GetMapping("opret")
    public String opret(HttpSession session)
    {
        if (Boolean.TRUE.equals(session.getAttribute("loggedIn")))
        {
            return "redirect:/";
        }
        return "home/opret";
    }

    @PostMapping("opret")
    public String processOpret(BrugerForm brugerForm, Model model)
    {
        Bruger nyBruger = new Bruger(brugerForm.getBrugernavn(), brugerForm.getAdgangskode(), brugerForm.getRolle());
        brugerService.tilfoejBruger(nyBruger);

        model.addAttribute("besked", "Bruger oprettet! Du kan nu logge ind.");
        return "home/login";
    }

    @GetMapping("logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/privatbruger")
    public String privatbruger()
    {
        return "home/privatbruger";
    }

    @GetMapping("/organisation")
    public String organisation() {
        return "home/organisation";
    }

    @GetMapping("/virksomhed")
    public String virksomhed() {
        return "home/virksomhed";
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

    @GetMapping("/opslagstavle")
    public String opslagstavle(HttpSession session) {
        if (!Boolean.TRUE.equals(session.getAttribute("loggedIn")))
            return "redirect:/login";
        return "home/opslagstavle";
    }

    @GetMapping("/tilmeldevent")
    public String tilmeldevent(HttpSession session) {
        if (!Boolean.TRUE.equals(session.getAttribute("loggedIn")))
            return "redirect:/login";
        return "home/tilmeldevent";
    }

    @GetMapping("/opretopslag")
    public String opretopslag(HttpSession session) {
        if (!Boolean.TRUE.equals(session.getAttribute("loggedIn")))
            return "redirect:/login";
        return "home/opretopslag";
    }

    @GetMapping("opretevent")
    public String opretevent(HttpSession session) {
        if (!Boolean.TRUE.equals(session.getAttribute("loggedIn")))
            return "redirect:/login";
        return "home/opretevent";
    }
}