package com.stornit.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// == JPA API Entity (javax.persistence)==
@Entity
public class Author {

    // == Fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String FIRST_NAME;
    private String LAST_NAME;

    // == object relational mapping ==

    // == set many to many relationship

    @ManyToMany(mappedBy = "authors")
    Set<Book> books = new HashSet<>();

    // == constructors ==
    public Author(String FIRST_NAME, String LAST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
    }

    public Author(String FIRST_NAME, String LAST_NAME, Set<Book> books) {
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.books = books;
    }

    public Author() {
    }

    // == getters and setters ==


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    // == Object equality method ==

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // == To String object ==


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", FIRST_NAME='" + FIRST_NAME + '\'' +
                ", LAST_NAME='" + LAST_NAME + '\'' +
                ", books=" + books +
                '}';
    }
}
