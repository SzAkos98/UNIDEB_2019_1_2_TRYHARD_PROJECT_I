package hu.unideb.inf.utils;


        import hu.unideb.inf.model.Book;
        import hu.unideb.inf.model.Loan;
        import hu.unideb.inf.model.Person;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.scene.control.Alert;
        import org.hibernate.Session;
        import org.hibernate.Transaction;

        import javax.persistence.PersistenceException;
        import javax.persistence.Query;


        import java.util.List;

        import static hu.unideb.inf.controller.utils.FXUtils.generateAlert;


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
                book = session.createQuery(" from Book ", Book.class).list();
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

    public static void persist(Object object) throws PersistenceException {
        transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            generateAlert(Alert.AlertType.ERROR, "Új könyv", "Hozzáadás", "Valamelyik érték érvénytelen!").show();

        }

    }


}
