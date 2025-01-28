package project.facade.books.repository;

import project.domain.entity.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookEntity, String> {
}