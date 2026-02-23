package com.udemy.springbatch.datamigration.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private LocalDate birth_date;
    private int age;
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<BankDetails> banks;

    public Person() {
    }

    public Person(int id, String name, String email, LocalDate birth_date, int age, List<BankDetails> bank) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth_date = birth_date;
        this.age = age;
        this.banks = bank;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    private void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public List<BankDetails> getBanks() {
        return banks;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(name, person.name)
                && Objects.equals(email, person.email) && Objects.equals(birth_date, person.birth_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, birth_date, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth_date=" + birth_date +
                ", age=" + age +
                ", bank=" + banks +
                '}';
    }

    public void addBanks(BankDetails bankDetails) {
        banks.add(bankDetails);
    }

    public void newPerson(String name, String email, LocalDate birth_date, int age, List<BankDetails> bank) {
        setName(name);
        setEmail(email);
        setBirth_date(birth_date);
        setAge(age);
        banks.forEach(this::addBanks);
    }
}
