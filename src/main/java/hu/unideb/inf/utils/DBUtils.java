package hu.unideb.inf.utils;


        import hu.unideb.inf.model.Book;
        import hu.unideb.inf.model.Loan;
        import hu.unideb.inf.model.Person;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.scene.control.Alert;
        import org.hibernate.Session;
        import org.hibernate.Transaction;

        import javax.persistence.Entity;
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

    public static ObservableList runQuery(String command, Tables tables){
        if(tables == Tables.BOOK){
            return runBookQuery(command);
        }
        else if(tables == Tables.PERSON){
            return runPersonQuery(command);
        }
        else {
            return runLoanQuery(command);
        }
    }

    private static ObservableList runLoanQuery(String command) {
        List<Loan> loan = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            if (command == null || command.equals("")) {
                loan = session.createQuery(" from Loan ", Loan.class).list();
            } else {
                loan = session.createQuery(command, Loan.class).list();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return FXCollections.observableList(loan);
    }

    private static ObservableList<Book> runBookQuery(String command) {
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

    private static ObservableList<Person> runPersonQuery(String command) {
        List<Person> person = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            if (command == null || command.equals("")) {
                person = session.createQuery(" from Person ", Person.class).list();
            } else {
                person = session.createQuery(command, Person.class).list();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return FXCollections.observableList(person);
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
