package org.vafin.bookshelfapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.vafin.bookshelfapp.dto.BookDTO;
import org.vafin.bookshelfapp.dto.BookRequest;
import org.vafin.bookshelfapp.exception.AuthorNotFoundException;
import org.vafin.bookshelfapp.exception.BookNotFoundException;
import org.vafin.bookshelfapp.model.Author;
import org.vafin.bookshelfapp.model.Book;
import org.vafin.bookshelfapp.repository.AuthorRepository;
import org.vafin.bookshelfapp.repository.BookRepository;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Page<BookDTO> getAllBooks(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return bookRepository.findAll(pageable).map(BookDTO::from);
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return BookDTO.from(book);
    }

    public BookDTO createBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setIsbn(bookRequest.getIsbn());
        book.setGenre(bookRequest.getGenre());
        book.setPublishingYear(bookRequest.getPublishingYear());
        book.setLanguage(bookRequest.getLanguage());
        book.setAuthor(resolveAuthor(bookRequest.getAuthorId()));

        return BookDTO.from(bookRepository.save(book));
    }

    public BookDTO updateBook(Long id, BookRequest updatedBook) {
        Book book = this.bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        book.setTitle(updatedBook.getTitle());
        book.setIsbn(updatedBook.getIsbn());
        book.setGenre(updatedBook.getGenre());
        book.setPublishingYear(updatedBook.getPublishingYear());
        book.setLanguage(updatedBook.getLanguage());
        book.setAuthor(resolveAuthor(updatedBook.getAuthorId()));
        return BookDTO.from(bookRepository.save(book));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private Author resolveAuthor(Long authorId) {
        if (authorId == null) {
            return null;
        }
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
    }
}
