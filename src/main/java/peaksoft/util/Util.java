package peaksoft.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user = "postgres";
    private final static String password = "405";


    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server\n" +
                    "successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public Connection connection() {
        return connect();
    }

    private static final SessionFactory session = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        } catch (Throwable ex) {
            System.out.println("Session not created" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSession() {
        return session;
    }

    public static void shutDown() {
        getSession().close();
    }
}
