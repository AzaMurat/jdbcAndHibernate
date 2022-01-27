package peaksoft.service;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
      UserDaoJdbcImpl jdbc = new UserDaoJdbcImpl();

    public void createUsersTable() {
        jdbc.createUsersTable();
    }
    public void dropUsersTable() {
        jdbc.dropUsersTable();
    }
    public void saveUser(String name, String lastName, byte age) {
        jdbc.saveUser(name,lastName,age);
    }
    public void removeUserById(long id) {
        jdbc.removeUserById(id);
    }
    public List<User> getAllUsers() {
        return jdbc.getAllUsers();
    }

    public void cleanUsersTable() {
        jdbc.cleanUsersTable();
    }
}
