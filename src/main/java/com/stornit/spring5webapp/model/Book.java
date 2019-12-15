package com.stornit.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// == JPA Api entity ( javax.presistence ) ==
@Entity
public class Book {

    // == Fields ==

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String TITLE;
    private String ISBN;
    private String PUBLISHER;

    // == Object Relational Mapping ==
    // == Many to Many realtionship
    @ManyToMany
    @JoinTable(name = "author_books", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    Set<Author> authors = new HashSet<>();

    // == Constructors ==

    public Book(String TITLE, String ISBN, String PUBLISHER) {
        this.TITLE = TITLE;
        this.ISBN = ISBN;
        this.PUBLISHER = PUBLISHER;
    }

    public Book(String TITLE, String ISBN, String PUBLISHER, Set<Author> authors) {
        this.TITLE = TITLE;
        this.ISBN = ISBN;
        this.PUBLISHER = PUBLISHER;
        this.authors = authors;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPUBLISHER() {
        return PUBLISHER;
    }

    public void setPUBLISHER(String PUBLISHER) {
        this.PUBLISHER = PUBLISHER;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", TITLE='" + TITLE + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", PUBLISHER='" + PUBLISHER + '\'' +
                ", authors=" + authors +
                '}';
    }
}
