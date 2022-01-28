package peaksoft.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.Util;

import javax.persistence.Query;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {

        Session session = Util.buildSessionFactory().openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        System.out.println("Table created!");

    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("drop User");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Удаление таблицы успешно : ");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            User user = new User();
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("Успешно добавлено : ");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            User user = (User) session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("успешно удален : ");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            List<User> user = session.createQuery("from User ").getResultList();
            session.getTransaction().commit();
            session.close();
            System.out.println(user.size());
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createQuery("DELETE FROM User").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Успешно удалены все пользователи : ");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
