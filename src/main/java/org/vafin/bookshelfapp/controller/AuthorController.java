package org.vafin.bookshelfapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vafin.bookshelfapp.model.Author;
import org.vafin.bookshelfapp.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.addAuthor(author));
    }

    @PutMapping
    public ResponseEntity<Author> updateAuthor(@RequestParam Long id, @RequestBody Author author) {
        return ResponseEntity.ok(authorService.updateAuthor(id, author));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAuthor(@RequestParam Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
