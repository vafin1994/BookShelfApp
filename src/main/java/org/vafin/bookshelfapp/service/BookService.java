package org.vafin.bookshelfapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.vafin.bookshelfapp.exception.BookNotFoundException;
import org.vafin.bookshelfapp.model.Book;
import org.vafin.bookshelfapp.repository.BookRepository;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Page<Book> getAllBooks(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return bookRepository.findAll(pageable);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book book = this.bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setIsbn(updatedBook.getIsbn());
        book.setGenre(updatedBook.getGenre());
        book.setPublishingYear(updatedBook.getPublishingYear());
        book.setLanguage(updatedBook.getLanguage());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
