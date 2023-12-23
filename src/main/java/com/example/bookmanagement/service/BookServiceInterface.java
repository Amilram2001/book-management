package com.example.bookmanagement.service;

import com.example.bookmanagement.dto.BookUpdate;
import com.example.bookmanagement.entity.Book;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BookServiceInterface {
    Book create(Book book);
    boolean delete(long id);

    Optional<Book> findOne(long id);

    boolean update(long id, BookUpdate book);

    Page<Book> getAll(int start, int end);
}
