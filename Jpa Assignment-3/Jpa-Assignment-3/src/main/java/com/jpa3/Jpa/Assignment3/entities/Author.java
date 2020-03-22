package com.jpa3.Jpa.Assignment3.entities;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name="author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String authorname;
    @Embedded
    Address address;
    @OneToMany(mappedBy = "author",cascade= CascadeType.ALL)
    private Set<Subjects> subjects;

    @OneToOne(mappedBy = "author",cascade = CascadeType.ALL)
    private Books books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subjects> subjects) {
        this.subjects = subjects;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }
}
