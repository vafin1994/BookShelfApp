package org.vafin.bookshelfapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vafin.bookshelfapp.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
