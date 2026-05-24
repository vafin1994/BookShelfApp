package org.vafin.bookshelfapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vafin.bookshelfapp.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
