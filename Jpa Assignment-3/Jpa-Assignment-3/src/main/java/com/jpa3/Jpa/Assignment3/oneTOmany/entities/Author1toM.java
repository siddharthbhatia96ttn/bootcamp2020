package com.jpa3.Jpa.Assignment3.oneTOmany.entities;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name="author1tom")
public class Author1toM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String authorname;
    @Embedded
    Address1toM address;
    @OneToMany(mappedBy = "author",cascade= CascadeType.ALL)
    private Set<Subjects1toM> subjects;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set <Books1toM> books;

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

    public Address1toM getAddress() {
        return address;
    }

    public void setAddress(Address1toM address) {
        this.address = address;
    }

    public Set<Subjects1toM> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subjects1toM> subjects) {
        this.subjects = subjects;
    }

    public Set<Books1toM> getBooks() {
        return books;
    }

    public void setBooks(Set<Books1toM> books) {
        this.books = books;
    }
}
