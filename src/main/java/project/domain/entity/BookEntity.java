package project.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "book")
public class BookEntity {
    @Id
    private String id;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private String category;
    private String description;
}

