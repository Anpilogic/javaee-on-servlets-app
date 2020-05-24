package com.anpilogov.entities;

public class User {

    private String id;
    private String login;
    private String password;
    private String role;

    private String name;
    private String surname;
    private int age;
    private String gender;
    private String country;

    public User() {}

    public User(String login, String password) { this.login = login; this.password = password; }

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String login, String password, String role,String name, String surname, int age, String gender, String country) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }
}
