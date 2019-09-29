package hu.unideb.inf.utils;


        import hu.unideb.inf.model.Person;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import org.hibernate.Session;
        import org.hibernate.Transaction;
        import javax.persistence.Query;
        import java.awt.print.Book;

        import java.util.List;


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

        final int i = 0;
        return i;
    }
    public static ObservableList<Book> runQuery(String command) {
        List<Book> book = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            if (command == null || command.equals("")) {
                book = session.createQuery("select id from Book ", Book.class).list();
            } else {
                book = session.createQuery(command, Book.class).list();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return FXCollections.observableList(book);
    }

}
