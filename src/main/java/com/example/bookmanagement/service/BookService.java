package com.example.bookmanagement.service;

import com.example.bookmanagement.dto.BookUpdate;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.example.bookmanagement.entity.Book;
import org.springframework.data.domain.PageRequest;
import com.example.bookmanagement.repository.BookRepositoryInterface;

import java.util.Optional;

@Service
public class BookService implements BookServiceInterface {
    private final BookRepositoryInterface bookRepository;

    public BookService(
            BookRepositoryInterface bookRepository
    ) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public boolean delete(long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Book> findOne(long id) {
        return bookRepository.findById(id).stream().findFirst();
    }

    @Override
    public boolean update(long id, BookUpdate book) {
        Optional<Book> oldBook = bookRepository.findById(id);
        if (oldBook.isEmpty()) {
            return false;
        }
        Book newBookToSave = oldBook.get();
        String title = book.title();
        String genre = book.genre();
        String author = book.author();
        if (author != null) {
            newBookToSave.setAuthor(author);
        }
        if (title != null) {
            newBookToSave.setTitle(title);
        }
        if (genre != null) {
            newBookToSave.setGenre(genre);
        }
        bookRepository.saveAndFlush(newBookToSave);
        return true;
    }

    @Override
    public Page<Book> getAll(int start, int end) {
        Pageable pageable = PageRequest.of(start, end);
        return bookRepository.findAll(pageable);
    }
}
