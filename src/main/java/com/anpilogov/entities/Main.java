package com.anpilogov.entities;

public class Main {

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        User user = new User("logiыn","dasdadada","user","name12","surname1",32,
                "male","country");
        User user2 = new User("login", "password");

        dao.authenticateUser(user2);
    }
}
