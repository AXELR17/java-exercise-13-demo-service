package com.devsenior.nluis.bookservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.devsenior.nluis.bookservice.model.Book;

@Service
public class MemoryBookService implements BookService{


    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findAll() {
         return books;
    }

    @Override
    public Book findById(String id) {
        /*for (Book book : books ) {
            if(book.getIsbn().equals(id)){
                return book;
            }
        }
        return null; */
        return books.stream()

            .filter(b -> b.getIsbn().equalsIgnoreCase(id))
            .peek(System.out::println)
            .findFirst()
            .orElse(null);
    }


    @Override
    public Book create(Book info) {
        books.add(info);
        return info;
    }

    @Override
    public Book update(String id, Book info) {
        var book = findById(id);
        if (book !=null) {
            book.setIsbn(info.getIsbn());
            book.setTitle(info.getTitle());
            book.setAuthor(info.getAuthor());  
        }
        return book;
    }

    @Override
    public void delete(String id) {
        // var book = findById(id);
        // books.remove(book);
        books = books.stream()
            .filter(b -> !b.getIsbn().equalsIgnoreCase(id))
            .toList();
    }
}
