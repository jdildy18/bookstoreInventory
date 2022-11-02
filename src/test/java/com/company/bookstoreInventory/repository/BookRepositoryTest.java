package com.company.bookstoreInventory.repository;

import com.company.bookstoreInventory.model.Author;
import com.company.bookstoreInventory.model.Book;
import com.company.bookstoreInventory.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {

        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();

    }

    @Test
    public void addGetDeleteBook() {

        Author author = new Author();
        author.setCity("Norfolk");
        author.setEmail("eiqpejrpjq@gmail.com");
        author.setPhone("323-642-7483");
        author.setFirstName("Jalen");
        author.setLastName("Anthony");
        author.setState("California");
        author.setStreet("743 Corprew Aveunue");
        author.setPostalCode("84892");
        author = authorRepository.save(author);

        Publisher publisher = new Publisher();
        publisher.setCity("Norfolk");
        publisher.setPostalCode("84783");
        publisher.setPhone("947-930-8343");
        publisher.setState("Texas");
        publisher.setName("Brandon");
        publisher.setEmail("3adjd202i@gmail.com");
        publisher.setStreet("332 Park Avenue");
        publisher = publisherRepository.save(publisher);

        Book book = new Book();
        book.setPublisherId(publisher.getId());
        book.setAuthorId(author.getId());
        book.setIsbn("97654356846");
        book.setTitle("The Greatest Race");
        book.setPublishDate(LocalDate.of(2002, 12, 23));
        book.setPrice(new BigDecimal("12.98"));
        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(), book);

        bookRepository.deleteById(book.getId());

        book1 = bookRepository.findById(book.getId());

        assertFalse(book1.isPresent());
    }

}