package com.tutorial;

public class Bokep {
    private String namaCwe, sizeBoobs, race, username;
    private int age;
    
    public Bokep(String namaCwe, String sizeBoobs, String race, int age) {
        this.namaCwe = namaCwe;
        this.sizeBoobs = sizeBoobs;
        this.race = race;
        this.age = age;
    }

    public void getNamaCwe() {
        System.out.println(namaCwe);
    }

    public void getSizeBoobs() {
        System.out.println(sizeBoobs);
    }

    public String getRace() {
        return race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNamaCwe(String namaCwe) {
        this.namaCwe = namaCwe;
        System.out.println(this.namaCwe);
    }
    
    
    


}
