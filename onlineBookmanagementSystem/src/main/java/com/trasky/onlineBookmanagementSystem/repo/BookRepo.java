package com.trasky.onlineBookmanagementSystem.repo;

import com.trasky.onlineBookmanagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);
}
