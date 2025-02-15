package project.facade.books.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookResponse {
    private String id;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private String category;
    private String description;
}
