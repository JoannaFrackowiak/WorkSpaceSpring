package com.startspring.workspace.user;

public class User {

    private int id;
    private String name;
    private String login;
    private String password;
    private int birthYear;

    public User() {

    }

    public User(int id, String name, String login, String password, int birthYear) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "idUser: " + id +
                ", name: " + name +
                ", login: " + login +
                ", birthYear " + birthYear + ".";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
