package com.udemy.springbatch.datamigration.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class BankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;
    private int branch;
    private int account;
    private int bank;

    public BankDetails() {
    }

    public BankDetails(int id, Person person, int branch, int account, int bank) {
        this.id = id;
        this.person = person;
        this.branch = branch;
        this.account = account;
        this.bank = bank;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankDetails that = (BankDetails) o;
        return id == that.id && branch == that.branch && account == that.account && bank == that.bank && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, branch, account, bank);
    }

    @Override
    public String toString() {
        return "BankDetails{" +
                "id=" + id +
                ", person=" + person +
                ", branch=" + branch +
                ", account=" + account +
                ", bank=" + bank +
                '}';
    }
}
