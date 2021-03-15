package com.spring.crud.demo.service;

import com.spring.crud.demo.entity.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {

    Map<Long, Book> books = new HashMap<>();

    public Map<Long, Book> findAll() {

        return books;
    }

    public Book findById(Long id) {

        return books.get(id);
    }

    public Book save(Book book) {

        books.put(book.getId(), book);

        return book;
    }

    public Map<Long, Book> findByPriceHigher(String price) {

        return new HashMap<>(books).entrySet().stream().
                filter(books -> Double.parseDouble(books.getValue().getPrice()) >= Double.parseDouble(price)).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Long, Book> findByPriceLower(String price) {

        return new HashMap<>(books).entrySet().stream().
                filter(books -> Double.parseDouble(books.getValue().getPrice()) <= Double.parseDouble(price)).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Long, Book> findByAuthor(String authorName) {

        Map<Long, Book> filteredBooks = new HashMap<>(books);

        filteredBooks.entrySet().stream().
                filter(books -> books.getValue().getAuthor().equals(authorName));

        return filteredBooks;
    }

    public Book update(Book book) {

        books.remove(book.getId(), book);

        books.put(book.getId(), book);

        return book;
    }

    public Book delete(Long id) {

        return books.remove(id);
    }
}
