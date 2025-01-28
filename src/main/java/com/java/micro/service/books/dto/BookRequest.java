package com.java.micro.service.books.dto;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private String category;
    private String description;
}
