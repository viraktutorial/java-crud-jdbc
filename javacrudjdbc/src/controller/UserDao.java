package controller;

import java.util.List;

import model.User;

public interface UserDao {
    User getUser(int id);
    List<User> getAllUsers();
    User getUserByUserNameAndPassword(String username, String password);
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
}