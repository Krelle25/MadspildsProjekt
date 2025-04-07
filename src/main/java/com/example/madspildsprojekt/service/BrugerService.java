package com.example.madspildsprojekt.service;

import com.example.madspildsprojekt.model.Bruger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrugerService
{
    private final List<Bruger> brugere = new ArrayList<>();

    public void tilfoejBruger(Bruger bruger)
    {
        brugere.add(bruger);
    }

    public Bruger findBruger(String brugernavn, String adgangskode)
    {
        for (Bruger b : brugere)
        {
            if (b.getBrugernavn().equals(brugernavn) && b.getAdgangskode().equals(adgangskode))
            {
                return b;
            }
        }
        return null;
    }
}
