package hu.unideb.inf.utils;


import hu.unideb.inf.model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBUtils {
    private static Transaction transaction;

    private static final String CON_STR = "jdbc:h2:file:~/db.properties;AUTO_SERVER=TRUE";



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

        final int i = 0;
        return i;
    }
    public void mbushTabelen(){
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    Connection conn = DriverManager.getConnection(CON_STR, "test", "test");
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from model.book");

                }catch (Exception ex){ex.printStackTrace();}
            }
        });
        t.start();
    }

}