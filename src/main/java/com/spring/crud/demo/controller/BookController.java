package com.spring.crud.demo.controller;

import com.spring.crud.demo.entity.Book;
import com.spring.crud.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {

        return new ResponseEntity<>(new ArrayList<>(bookService.findAll().values()), HttpStatus.OK);
    }

    @GetMapping(path = "/getByPriceLower")
    public ResponseEntity<List<Book>> getByPriceLower(@RequestParam String price) {

        return new ResponseEntity<>(new ArrayList<>(bookService.findByPriceLower(price).values()), HttpStatus.OK);
    }

    @GetMapping(path = "/getByPriceHigher")
    public ResponseEntity<List<Book>> getByPriceHigher(@RequestParam String price) {

        return new ResponseEntity<>(new ArrayList<>(bookService.findByPriceHigher(price).values()), HttpStatus.OK);
    }

    @GetMapping(path = "/getByAuthorName")
    public ResponseEntity<List<Book>> getByAuthorName(@RequestParam String authorName) {

        return new ResponseEntity<>(new ArrayList<>(bookService.findByAuthor(authorName).values()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(Long id) {

        Book book = bookService.findById(id);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(Book book) {

        Book savedBook = bookService.save(book);

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(Book book) {

        Book updatedBook = bookService.update(book);

        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Long bookId) {

        bookService.delete(bookId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
