package hu.unideb.inf.controller;


import hu.unideb.inf.model.Book;
import hu.unideb.inf.model.Loan;
import hu.unideb.inf.utils.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.util.Date;

import static hu.unideb.inf.controller.utils.FXUtils.*;

public class BookLoanController {

    @FXML
    protected TableView<Book> cart;

    @FXML
    protected TableView<Book> table;

    @FXML
    protected TextField id;

    @FXML
    protected TextField author;

    @FXML
    protected TextField title;

    @FXML
    protected TextField publisher;

    @FXML
    protected TextField yearOfPublication;

    @FXML
    protected Label person;

    @FXML
    protected Button addToLoan;

    @FXML
    protected Button deleteCartItem;

    private Book selectedBook;

    private Book backBook;

    public void initialize(){
        person.setText( LoanController.person.getFirstName()+ LoanController.person.getLastName());
        refreshTables();

    }

    public void handleSelection(MouseEvent mouseEvent) {
        selectedBook = table.getSelectionModel().getSelectedItem();
        addToLoan.disableProperty().setValue(false);
    }

    public void handleCartSelection(MouseEvent mouseEvent) {
        backBook = cart.getSelectionModel().getSelectedItem();
        deleteCartItem.disableProperty().setValue(false);
    }

    public void handleTyping(KeyEvent keyEvent) {

    }

    public void handleAddToLoan(ActionEvent actionEvent) {
        Date deadline = DateUtils.addMonths(new Date(), 1);
        Loan loan = new Loan(null, selectedBook.getId(), LoanController.person.getId(),new java.sql.Date(new Date().getTime()), new java.sql.Date(deadline.getTime()) ,null);
        DBUtils.persist(loan);
        addToLoan.disableProperty().setValue(true);
        refreshTables();

    }

    public void handleLoan(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/MainMenu.fxml"));

    }

    public void handleBack(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/Loan.fxml"));
    }


    public void handleDeleteBook(ActionEvent actionEvent) {
        System.out.println("update Loan set backDate = " + new java.sql.Date(new Date().getTime()) + " Where bookID = " + backBook.getId() + " and backDate is null");
        DBUtils.updateTable("update Loan set backDate = \'" + new java.sql.Date(new Date().getTime()) + "\' Where bookID = " + backBook.getId() + " and backDate is null");
        refreshTables();
        addToLoan.disableProperty().setValue(true);

    }

    private void refreshTables() {
        refreshBookTableView(table, "from Book where id in (select bookID From Loan WHERE backDate is not null) or id not in (select bookID From Loan WHERE backDate is null)");
        refreshBookTableView(cart, "from Book where id in (select bookID From Loan WHERE backDate is null and personID = "+ LoanController.person.getId()+ ")");
    }
}
