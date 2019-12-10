package com.example.prueba;

public class profesor {

    //clase que contiene todos los atributos de el nodo en la base de datos
    //los nombres deben ser los mismo qye en la base de datos.

    private String email;
    private String firstname;
    private String lastname;
    private String role;

    public profesor() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
