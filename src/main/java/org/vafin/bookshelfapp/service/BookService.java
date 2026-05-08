package org.vafin.bookshelfapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vafin.bookshelfapp.model.Book;
import org.vafin.bookshelfapp.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book book = this.bookRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
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
