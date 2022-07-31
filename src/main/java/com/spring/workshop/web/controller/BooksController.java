package com.spring.workshop.web.controller;

import com.spring.workshop.web.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return List.of(new Book(1, "wikara", "xalxuri"),
                new Book(2, "komble", "xalxuri"));
    }
}
