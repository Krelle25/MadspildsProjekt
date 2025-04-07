package com.example.madspildsprojekt.model;

public class BrugerForm {
    private String brugernavn;
    private String adgangskode;
    private String rolle;

    // Getters og setters
    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public String getAdgangskode() {
        return adgangskode;
    }

    public void setAdgangskode(String adgangskode) {
        this.adgangskode = adgangskode;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }
}
