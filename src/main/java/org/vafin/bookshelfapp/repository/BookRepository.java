package org.vafin.bookshelfapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vafin.bookshelfapp.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
