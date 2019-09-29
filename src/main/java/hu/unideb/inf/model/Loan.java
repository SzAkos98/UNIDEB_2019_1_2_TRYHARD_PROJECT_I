package hu.unideb.inf.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class Loan {
    @Id
    @Column
    private Long id;

    @Column
    private Long bookID;

    @Column
    private Long personID;

    @Column
    private Date loanDate;

    @Column
    private Date deadLine;

    @Column
    private Date backDate;

    public Loan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public Long getPersonID() {
        return personID;
    }

    public void setPersonID(Long personID) {
        this.personID = personID;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    public Loan(Long id, Long bookID, Long personID, Date loanDate, Date deadLine, Date backDate) {
        this.id = id;
        this.bookID = bookID;
        this.personID = personID;
        this.loanDate = loanDate;
        this.deadLine = deadLine;
        this.backDate = backDate;
    }
}

