package com.java.micro.service.books.dto;


import com.java.micro.service.books.entity.BookEntity;

import java.util.UUID;

public class BookMapper {
    public static BookEntity toRequest(BookRequest request) {
        return new BookEntity(
                UUID.randomUUID().toString(),
                request.getTitle(),
                request.getAuthor(),
                request.getPublisher(),
                request.getIsbn(),
                request.getCategory(),
                request.getDescription()
        );
    }

    public static BookResponse toResponse(BookEntity entity) {
        return new BookResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getAuthor(),
                entity.getPublisher(),
                entity.getIsbn(),
                entity.getCategory(),
                entity.getDescription()
        );
    }

    public static BookEntity updateEntity(BookEntity entity, BookRequest request) {
        entity.setTitle(request.getTitle());
        entity.setAuthor(request.getAuthor());
        entity.setPublisher(request.getPublisher());
        entity.setIsbn(request.getIsbn());
        entity.setCategory(request.getCategory());
        entity.setDescription(request.getDescription());
        return entity;
    }
}
