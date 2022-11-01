package com.company.bookstoreInventory.repository;

import com.company.bookstoreInventory.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllBooksByAuthorId(int authorId);
}
