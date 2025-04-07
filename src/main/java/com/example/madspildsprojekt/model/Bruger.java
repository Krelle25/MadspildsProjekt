package com.example.madspildsprojekt.model;

public class Bruger
{
    private String brugernavn;
    private String adgangskode;
    private String rolle;

    public Bruger(String brugernavn, String adgangskode, String rolle)
    {
        this.brugernavn = brugernavn;
        this.adgangskode = adgangskode;
        this.rolle = rolle;
    }

    public String getBrugernavn()
    {
        return brugernavn;
    }

    public String getAdgangskode()
    {
        return adgangskode;
    }

    public String getRolle()
    {
        return rolle;
    }
}
