package org.vafin.bookshelfapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vafin.bookshelfapp.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
}
