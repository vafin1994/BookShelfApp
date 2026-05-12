package org.vafin.bookshelfapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vafin.bookshelfapp.exception.AuthorNotFoundException;
import org.vafin.bookshelfapp.model.Author;
import org.vafin.bookshelfapp.repository.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }
//
//    public Author updateAuthor(Long id, Author author) {
//
//    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

}
