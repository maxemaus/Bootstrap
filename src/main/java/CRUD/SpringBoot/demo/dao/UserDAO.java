package CRUD.SpringBoot.demo.dao;

import CRUD.SpringBoot.demo.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsersList();
    void add(User user);
    void delete(Long id);
    void edit(User user);
    User findById(Long id);
    User getUserByName(String name);
}
