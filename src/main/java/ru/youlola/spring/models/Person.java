package ru.youlola.spring.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "year_of_birth")
    @Min(value = 0,message = "Age should be greater than 0")
    private int yearOfBirth;

    @NotEmpty(message = "Поле ФИО не может быть пустым")
    @Column(name = "full_name")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длинной")
    private String fullName;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;

    public Person(){

    }

    public Person(String fullName, int yearOfBirth) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
//        this.email = email;
//        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", yearOfBirth=" + yearOfBirth +
//                ", fullName='" + fullName + '\'' +
//                ", books=" + books +
//                '}';
//    }
}

