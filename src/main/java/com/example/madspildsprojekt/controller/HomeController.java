package com.example.madspildsprojekt.controller;
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

    // Login-side
    @GetMapping("login")
    public String login(HttpSession session)
    {
        // Hvis brugeren allerede er logget ind, send dem tilbage til forsiden
        if (Boolean.TRUE.equals(session.getAttribute("loggedIn")))
        {
            return "redirect:/";
        }
        return "home/login"; // Ellers vis login-siden
    }

    // Håndterer login-formular
    @PostMapping("login")
    public String processLogin(BrugerForm form, HttpSession session, Model model)
    {
        // Validerer brugernavn og adgangskode
        Bruger bruger = brugerService.findBruger(form.getBrugernavn(), form.getAdgangskode());

        if (bruger != null)
        {
            // Gem brugerdata i sessionen (hvis login lykkedes)
            session.setAttribute("loggedIn", true);
            session.setAttribute("brugerType", bruger.getRolle());
            session.setAttribute("brugernavn", bruger.getBrugernavn());

            // Viderestiller brugeren til deres respektive side baseret på rolle
            return "redirect:/" + bruger.getRolle();
        } else {
            // Hvis login mislykkes + fejlbesked
            model.addAttribute("besked", "Forkert brugernavn eller adgangskode.");
            return "home/login";
        }
    }

    // Registreringsside (opret konto)
    @GetMapping("opret")
    public String opret(HttpSession session)
    {
        // Hvis brugeren allerede er logget ind, send dem tilbage til forsiden
        if (Boolean.TRUE.equals(session.getAttribute("loggedIn")))
        {
            return "redirect:/";
        }
        return "home/opret"; // Ellers vis registreringssiden
    }

    // Behandling af registreringsformular
    @PostMapping("opret")
    public String processOpret(BrugerForm brugerForm, Model model)
    {
        // Opretter ny bruger med data fra formularen
        Bruger nyBruger = new Bruger(brugerForm.getBrugernavn(), brugerForm.getAdgangskode(), brugerForm.getRolle());
        brugerService.tilfoejBruger(nyBruger);

        // Bekræftelsesbesked om konto-oprettelse (vises på login-side)
        model.addAttribute("besked", "Bruger oprettet! Du kan nu logge ind.");
        return "home/login";
    }

    // Log ud af systemet
    @GetMapping("logout")
    public String logout(HttpSession session)
    {
        session.invalidate(); // Invaliderer nuværende session (fjerner login-info)
        return "redirect:/"; // Redirect til forsiden efter logout
    }

    // Brugerspecifikke side for 'privatforbruger'
    @GetMapping("/privatbruger")
    public String privatbruger()
    {
        return "home/privatbruger";
    }

    // Brugerspecifikke side for 'organisation'
    @GetMapping("/organisation")
    public String organisation() {
        return "home/organisation";
    }

    // Brugerspecifikke side for 'virksomhed'
    @GetMapping("/virksomhed")
    public String virksomhed() {
        return "home/virksomhed";
    }

    // Informationsside for 'privatforbruger'
    @GetMapping("privatinfo")
    public String privatinfo()
    {
        return "home/privatinfo";
    }

    // Informationsside for 'organisation'
    @GetMapping("organisationinfo")
    public String organisationinfo()
    {
        return "home/organisationinfo";
    }

    // Informationsside for 'virksomhed'
    @GetMapping("virksomhedinfo")
    public String virksomhedinfo()
    {
        return "home/virksomhedinfo";
    }

    // Opslagstavle (kræver login)
    @GetMapping("/opslagstavle")
    public String opslagstavle(HttpSession session) {
        // Hvis bruger ikke er logget ind --> send til login
        if (!Boolean.TRUE.equals(session.getAttribute("loggedIn")))
            return "redirect:/login";
        return "home/opslagstavle";
    }

    // Tilmeldning til event (kræver login)
    @GetMapping("/tilmeldevent")
    public String tilmeldevent(HttpSession session) {
        // Hvis bruger ikke er logget ind --> send til login
        if (!Boolean.TRUE.equals(session.getAttribute("loggedIn")))
            return "redirect:/login";
        return "home/tilmeldevent";
    }
    // Opret opslag (kræver login)
    @GetMapping("/opretopslag")
    public String opretopslag(HttpSession session) {
        // Hvis bruger ikke er logget ind --> send til login
        if (!Boolean.TRUE.equals(session.getAttribute("loggedIn")))
            return "redirect:/login";
        return "home/opretopslag";
    }

    // Opret event (kræver login)
    @GetMapping("opretevent")
    public String opretevent(HttpSession session) {
        // Hvis bruger ikke er logget ind --> send til login
        if (!Boolean.TRUE.equals(session.getAttribute("loggedIn")))
            return "redirect:/login";
        return "home/opretevent";
    }
}