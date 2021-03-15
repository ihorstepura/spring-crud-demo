package com.spring.crud.demo.entity;

import org.springframework.lang.NonNull;

public class Book {

    private Long id;
    private String name;
    private String author;
    private String price;

    public Long getId() {
        return id;
    }

    @NonNull
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @NonNull
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    @NonNull
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    @NonNull
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
