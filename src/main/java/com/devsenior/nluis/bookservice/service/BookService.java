package com.devsenior.nluis.bookservice.service;

import java.util.List;

import com.devsenior.nluis.bookservice.model.Book;

public interface BookService {
    List<Book> findAll();

    Book findById(String id);

    Book create(Book info);

    Book update(String id, Book info);
    
    void delete(String id);
}
