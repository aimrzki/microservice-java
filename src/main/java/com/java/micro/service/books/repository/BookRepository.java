package com.java.micro.service.books.repository;

import com.java.micro.service.books.entity.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookEntity, String> {
}