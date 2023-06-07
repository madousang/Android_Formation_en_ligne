package com.example.firebase_register;

public class Formation {
    private String formationName;
    private String formationtime;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String usernameformation) {
        this.username = usernameformation;
    }

    public Formation(){

    }

    public void setFormationName(String formationName) {
        this.formationName = formationName;
    }

    public void setFormationtime(String formationtime) {
        this.formationtime = formationtime;
    }

    public Formation(String formationName, String formationtime, String username) {
        this.username = username;
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
