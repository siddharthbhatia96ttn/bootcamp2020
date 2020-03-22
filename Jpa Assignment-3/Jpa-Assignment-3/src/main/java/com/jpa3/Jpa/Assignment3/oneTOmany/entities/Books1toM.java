package com.jpa3.Jpa.Assignment3.oneTOmany.entities;

import com.jpa3.Jpa.Assignment3.entities.Author;

import javax.persistence.*;
@Entity
@Table(name="book1tom")
public class Books1toM {
    @Id
    private int id;
    private String book_name;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author1toM author;
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

    public Author1toM getAuthor() {
        return author;
    }

    public void setAuthor(Author1toM author) {
        this.author = author;
    }
}
