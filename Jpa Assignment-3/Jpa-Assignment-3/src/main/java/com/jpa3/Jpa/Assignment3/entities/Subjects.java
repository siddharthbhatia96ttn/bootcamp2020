package com.jpa3.Jpa.Assignment3.entities;

import javax.persistence.*;

@Entity
@Table(name="subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sub_id;
    private String sub_name;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;
    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
