package com.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "man")
public class Man {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "sur_name")
    private String surName;


    @Column(name = "age")
    private int age;

    @Column(name = "date_Of_birth")
    private String dateOfBirth;

    public Man() {
    }

    public Man(String firstName, String surName, int age, String dateOfBirth) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return id == man.id &&
                age == man.age &&
                Objects.equals(firstName, man.firstName) &&
                Objects.equals(surName, man.surName) &&
                Objects.equals(dateOfBirth, man.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, surName, age, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
