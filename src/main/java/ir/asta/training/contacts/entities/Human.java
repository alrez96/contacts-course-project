package ir.asta.training.contacts.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Human {
    @Id
    @Column
    String username;
    @Basic
    @Column
    String emailAddress;
    @Basic
    @Column
    String name;
    @Basic
    @Column
    String pass;


    public String getName() {return name; }

    public void setName(String name) { this.name = name; }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPass() {
        return pass;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
