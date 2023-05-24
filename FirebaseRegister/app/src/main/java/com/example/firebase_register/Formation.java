package com.example.firebase_register;

public class Formation {
    private String formationName;
    private String formationtime;

    public Formation(){

    }

    public void setFormationName(String formationName) {
        this.formationName = formationName;
    }

    public void setFormationtime(String formationtime) {
        this.formationtime = formationtime;
    }

    public Formation(String formationName, String formationtime) {
        this.formationName = formationName;
        this.formationtime = formationtime;
    }


    public String getFormationName() {
        return formationName;
    }

    public String getFormationtime() {
        return formationtime;
    }
}
