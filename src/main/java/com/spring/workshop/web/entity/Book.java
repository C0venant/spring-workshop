package com.spring.workshop.web.entity;

import lombok.Data;

@Data
public class Book {
    private final long id;
    private final String name;
    private final String author;
}
