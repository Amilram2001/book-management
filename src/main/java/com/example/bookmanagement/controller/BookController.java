package com.example.bookmanagement.controller;

import com.example.bookmanagement.dto.BookUpdate;
import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.service.BookServiceInterface;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping({"books", "books/"})
public class BookController {
    private final BookServiceInterface bookService;

    public BookController(
            BookServiceInterface bookService
    ) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Page<Book>> getBooks(
            @RequestParam(defaultValue = "0") int start,
            @RequestParam(defaultValue = "10") int end
    ) {
        return ResponseEntity.ok(bookService.getAll(start, end));
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBook(
            @PathVariable long id
    ) {
        Optional<Book> book = bookService.findOne(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> addBook(
            @Valid @RequestBody Book book
    ) {
        var created = bookService.create(book);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateBook(
            @PathVariable long id,
            @Valid @RequestBody BookUpdate book
    ) {
        if (bookService.update(id, book)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(
            @PathVariable long id
    ) {
        if (bookService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
