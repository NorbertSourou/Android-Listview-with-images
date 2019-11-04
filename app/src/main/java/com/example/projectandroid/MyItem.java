package com.example.projectandroid;

import java.io.Serializable;

public class MyItem implements Serializable {
    private int imageid;
    private String nom = "";
    private String prenom = "";
    private String contact = "";
    private String email = "";

    public MyItem(int imageid, String nom, String prenom, String contact, String email) {
        this.imageid = imageid;
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
        this.email = email;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
