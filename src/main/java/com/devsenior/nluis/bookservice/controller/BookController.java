package com.devsenior.nluis.bookservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nluis.bookservice.model.Book;
import com.devsenior.nluis.bookservice.service.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/books")
public class BookController {  //Servicio RESTful
    
    @Autowired
    private BookService bookservice;



    @GetMapping //GET /api/books
    public List<Book> getAll() {
        return bookservice.findAll();
    }

     @GetMapping ("/{isbn}")//GET /api/books/12345
    public Book getByIsbn(@PathVariable String isbn) {
         return bookservice.findById(isbn);
    }

     @PostMapping // POST /api/books -> Body
    public Book newBook(@RequestBody Book book) {
        return bookservice.create(book);
    }

    @PutMapping ("/{isbn}") // PUT /api/books/12345 -> Body
    public Book updateBook(@PathVariable String isbn, @RequestBody Book book) {
        return bookservice.update(isbn, book);
    }

    @DeleteMapping("/{isbn}") 
    public void deleteBook(@PathVariable String isbn) {
        bookservice.delete(isbn);
    
    }






}
