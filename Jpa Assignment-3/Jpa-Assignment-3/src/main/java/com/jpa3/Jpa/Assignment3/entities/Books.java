package com.jpa3.Jpa.Assignment3.entities;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Books {
    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String book_name;
    @OneToOne
    @JoinColumn(name="author_id")
    private Author author;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
