package com.anpilogov.entities;

import com.anpilogov.connections.ConnectDB;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.LogManager.*;

public class UserDAO{


    public String authenticateUser(User user){

        String IS_USER_IN_DB = "select login,password from users";

       try (Connection dbConnection = ConnectDB.establishConnection();
            Statement statement = dbConnection.createStatement())
       {
           ResultSet resultSet = statement.executeQuery(IS_USER_IN_DB);
           while (resultSet.next()){
               String dbUserLogin = resultSet.getString("login");
               String dbUserPassword = resultSet.getString("password");

               if(user.getLogin().equals(dbUserLogin) && user.getPassword().equals(dbUserPassword)){
                   return "login success";
               }
           }
       } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
       }
        return "incorrect login or password";
    }

    //synchronized или используются "блокировщики"???
    public  String  registerNewUser(User user){
        String CREATE_USER = "insert into users (login,password,role) values (?,?,?)";
        String CREATE_USER_PERSONS = "insert into user_persons (name,surname,age,gender,country) values (?,?,?,?,?)";

        //autocloseable inf usin'
        try (Connection dbConnection = ConnectDB.establishConnection();
             PreparedStatement preparedStatement1 = dbConnection.prepareStatement(CREATE_USER);
             PreparedStatement preparedStatement2 = dbConnection.prepareStatement(CREATE_USER_PERSONS);)
        {
            preparedStatement1.setString(1,user.getLogin());
            preparedStatement1.setString(2,user.getPassword());
            preparedStatement1.setString(3,"user");

            preparedStatement2.setString(1,user.getName());
            preparedStatement2.setString(2,user.getSurname());
            preparedStatement2.setInt(3,user.getAge());
            preparedStatement2.setString(4,user.getGender());
            preparedStatement2.setString(5,user.getCountry());

            int userCreate = preparedStatement1.executeUpdate();
            int personCreate = preparedStatement2.executeUpdate();

            if(userCreate!= 0 && personCreate!=0){
                dbConnection.commit();
                //log
                return "registration successful"; }
        } catch (ClassNotFoundException | SQLException e) {
            //событие для логера
            System.out.println("Sorry but login you choose already created..please choose another login");
        }
        //добавить событие для логера
        return "not good";
    }

    //добавить инсерты в таблицу админа...//// отдельный класс

}
