package com.java.micro.service.books;

import com.java.micro.service.books.dto.BookRequest;
import com.java.micro.service.responseV1.ResponseApiV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BooksService service;

    @PostMapping
    public ResponseEntity<ResponseApiV1<?>> createBook(@RequestBody BookRequest request) {
        ResponseApiV1<?> response = service.createBook(request);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseApiV1<?>> getBookById(@PathVariable String id) {
        ResponseApiV1<?> response = service.getBookById(id);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @GetMapping
    public ResponseEntity<ResponseApiV1<?>> getAllBooks() {
        ResponseApiV1<?> response = service.getAllBooks();
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseApiV1<?>> updateBook(
            @PathVariable String id,
            @RequestBody BookRequest request
    ) {
        ResponseApiV1<?> response = service.updateBook(id, request);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseApiV1<?>> deleteBook(@PathVariable String id) {
        ResponseApiV1<?> response = service.deleteBook(id);
        return ResponseEntity.status(response.getCode()).body(response);
    }
}
