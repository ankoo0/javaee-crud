package com.project.javaeecrud.dao;



import com.project.javaeecrud.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    private static final Logger logger = Logger.getLogger("My Logger");


    private static final String SELECT_ALL_USERS = "SELECT * FROM USERS";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM USERS WHERE ID=?";
    private static final String UPDATE_USER = "UPDATE USERS SET FIRST_NAME=?,LAST_NAME=?,AGE=?,EMAIL=?,POSITION=? WHERE ID=?";
    private static final String DELETE_USER = "DELETE FROM USERS WHERE ID=?;";
    private static final String INSERT_USER = "INSERT INTO USERS (FIRST_NAME, LAST_NAME, AGE, EMAIL, POSITION) VALUES (?,?,?,?,?)";

    private UserDAO(){

    }


    public  static List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        try(Connection conn = DataBaseConnection.getConnection()){
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String fName = resultSet.getString(2);
                String lName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                String email = resultSet.getString(5);
                String position = resultSet.getString(6);
                User user = new User(id,fName,lName,age,email,position);
                users.add(user);
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE,e.getMessage(),e);
        }
            logger.log(Level.INFO,"Selected all users from database");

        return users;
    }

    public static boolean deleteUser(int id){
        try(Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER);
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            logger.log(Level.SEVERE,e.getMessage(),e);
            return false;
        }
        return true;
    }

    public static boolean updateUser(int id, User user) {
        try(Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setInt(3,user.getAge());
            statement.setString(4,user.getEmail());
            statement.setString(5,user.getPosition());
            statement.setInt(6,id);
            statement.executeUpdate();
        }catch (SQLException e){
            logger.log(Level.SEVERE,e.getMessage(),e);
            return false;
        }
        return true;
    }

    public  static boolean insertUser(User user){
        try(Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_USER);
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setInt(3,user.getAge());
            statement.setString(4,user.getEmail());
            statement.setString(5,user.getPosition());
         statement.executeUpdate();

        }catch (SQLException e){
            logger.log(Level.SEVERE,e.getMessage(),e);
            return false;
        }
        return true;
    }

    public  static User getUserById(int userId){
        User user = null;
        try(Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement statement = conn.prepareStatement(SELECT_USER_BY_ID);
            statement.setInt(1,userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String fName = resultSet.getString(2);
                String lName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                String email = resultSet.getString(5);
                String position = resultSet.getString(6);
                user = new User(id,fName,lName,age,email,position);
            }
        } catch (SQLException e){
            logger.log(Level.SEVERE,e.getMessage(),e);
        }
        logger.log(Level.INFO,"Selected user " + user.toString() + " from database");

        return user;
    }


}
