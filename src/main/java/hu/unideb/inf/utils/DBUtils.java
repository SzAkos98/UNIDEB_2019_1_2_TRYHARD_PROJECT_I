package hu.unideb.inf.utils;


import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;
import javax.persistence.Query;



public class DBUtils {
    private static Transaction transaction;

    public static Integer updateTable(String command) {
        Query query = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            query = session.createQuery(command);
            return query.executeUpdate();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return 0;
    }

}
