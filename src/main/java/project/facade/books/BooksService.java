package project.facade.books;

import project.facade.books.dto.BookMapper;
import project.facade.books.dto.BookRequest;
import project.facade.books.dto.BookResponse;
import project.domain.entity.BookEntity;
import project.domain.repository.BookRepository;
import project.common.responseV1.ResponseApiV1;
import project.common.responseV1.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BooksService {
    @Autowired
    private BookRepository repository;

    public ResponseApiV1<?> createBook(BookRequest request) {
        try {
            BookEntity entity = BookMapper.toEntity(request);
            log.info("Book entity: {}", entity);
            BookEntity savedEntity = repository.save(entity);
            BookResponse response = BookMapper.toResponse(savedEntity);
            return ResponseApiV1.success(response);
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseApiV1.error(ResponseStatus.INTERNAL_ERROR);
        }
    }

    public ResponseApiV1<?> getBookById(String id) {
        try {
            Optional<BookEntity> bookOptional = repository.findById(id);
            if (bookOptional.isPresent()) {
                BookResponse response = BookMapper.toResponse(bookOptional.get());
                return ResponseApiV1.success(response);
            } else {
                return ResponseApiV1.error(ResponseStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseApiV1.error(ResponseStatus.INTERNAL_ERROR);
        }
    }

    public ResponseApiV1<?> getAllBooks() {
        try {
            List<BookEntity> books = repository.findAll();
            List<BookResponse> responses = books.stream()
                    .map(BookMapper::toResponse)
                    .collect(Collectors.toList());
            return ResponseApiV1.success(responses);
        } catch (Exception e) {
            return ResponseApiV1.error(ResponseStatus.INTERNAL_ERROR);
        }
    }

    public ResponseApiV1<?> updateBook(String id, BookRequest request) {
        try {
            Optional<BookEntity> bookOptional = repository.findById(id);
            if (bookOptional.isPresent()) {
                BookEntity existingBook = bookOptional.get();
                BookMapper.updateEntity(existingBook, request);
                BookEntity updatedBook = repository.save(existingBook);
                return ResponseApiV1.success(BookMapper.toResponse(updatedBook));
            } else {
                return ResponseApiV1.error(ResponseStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseApiV1.error(ResponseStatus.INTERNAL_ERROR);
        }
    }

    public ResponseApiV1<?> deleteBook(String id) {
        try {
            Optional<BookEntity> bookOptional = repository.findById(id);
            if (bookOptional.isPresent()) {
                repository.deleteById(id);
                return ResponseApiV1.success(null);
            } else {
                return ResponseApiV1.error(ResponseStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseApiV1.error(ResponseStatus.INTERNAL_ERROR);
        }
    }
}
