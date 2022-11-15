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
import java.util.List;
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

        Publisher publisher = new Publisher();
        publisher.setCity("Norfolk");
        publisher.setPostalCode("84783");
        publisher.setPhone("947-930-8343");
        publisher.setState("TX");
        publisher.setName("Brandon");
        publisher.setEmail("3adjd202i@gmail.com");
        publisher.setStreet("332 Park Avenue");

        publisher = publisherRepository.save(publisher);

        Author author = new Author();
        author.setCity("Norfolk");
        author.setEmail("eiqpejrpjq@gmail.com");
        author.setPhone("323-642-7483");
        author.setFirstName("Jalen");
        author.setLastName("Anthony");
        author.setState("CA");
        author.setStreet("743 Corprew Aveunue");
        author.setPostalCode("84892");
        author = authorRepository.save(author);

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

    @Test
    public void updateBook() {

        Publisher publisher = new Publisher();
        publisher.setCity("Norfolk");
        publisher.setPostalCode("84783");
        publisher.setPhone("947-930-8343");
        publisher.setState("TX");
        publisher.setName("Brandon");
        publisher.setEmail("3adjd202i@gmail.com");
        publisher.setStreet("332 Park Avenue");
        publisher = publisherRepository.save(publisher);

        Author author = new Author();
        author.setCity("Norfolk");
        author.setEmail("eiqpejrpjq@gmail.com");
        author.setPhone("323-642-7483");
        author.setFirstName("Jalen");
        author.setLastName("Anthony");
        author.setState("CA");
        author.setStreet("743 Corprew Aveunue");
        author.setPostalCode("84892");
        author = authorRepository.save(author);

        Book book = new Book();
        book.setPublisherId(publisher.getId());
        book.setAuthorId(author.getId());
        book.setIsbn("97654356846");
        book.setTitle("The Greatest Race");
        book.setPublishDate(LocalDate.of(2002, 12, 23));
        book.setPrice(new BigDecimal("12.98"));
        book = bookRepository.save(book);

        book.setIsbn("043092309322");
        book.setTitle("All American");
        book.setPublishDate(LocalDate.of(2015, 8, 18));
        book.setPrice(new BigDecimal("19.99"));

        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());
        assertEquals(book1.get(), book);
    }

    @Test
    public void getBookByAuthorId() {
    // Create Publisher, Author, and Book First
        Publisher publisher = new Publisher();
        publisher.setCity("Norfolk");
        publisher.setPostalCode("84783");
        publisher.setPhone("947-930-8343");
        publisher.setState("TX");
        publisher.setName("Brandon");
        publisher.setEmail("3adjd202i@gmail.com");
        publisher.setStreet("332 Park Avenue");
        publisher = publisherRepository.save(publisher);

        Author author = new Author();
        author.setCity("Norfolk");
        author.setEmail("eiqpejrpjq@gmail.com");
        author.setPhone("323-642-7483");
        author.setFirstName("Jalen");
        author.setLastName("Anthony");
        author.setState("CA");
        author.setStreet("743 Corprew Aveunue");
        author.setPostalCode("84892");
        author = authorRepository.save(author);

        Book book = new Book();
        book.setPublisherId(publisher.getId());
        book.setAuthorId(author.getId());
        book.setIsbn("97654356846");
        book.setTitle("The Greatest Race");
        book.setPublishDate(LocalDate.of(2002, 12, 23));
        book.setPrice(new BigDecimal("12.98"));
        book = bookRepository.save(book);

        Book book1 = new Book();
        book1.setPublisherId(publisher.getId());
        book1.setAuthorId(author.getId());
        book1.setIsbn("8948939298");
        book1.setTitle("On The Run");
        book1.setPublishDate(LocalDate.of(2012, 1, 15));
        book1.setPrice(new BigDecimal("7.99"));
        book1 = bookRepository.save(book1);

    }

    @Test
    public void getAllBooks() {
        Publisher publisher = new Publisher();
        publisher.setCity("Norfolk");
        publisher.setPostalCode("84783");
        publisher.setPhone("947-930-8343");
        publisher.setState("TX");
        publisher.setName("Brandon");
        publisher.setEmail("3adjd202i@gmail.com");
        publisher.setStreet("332 Park Avenue");
        publisher = publisherRepository.save(publisher);

        Author author = new Author();
        author.setCity("Norfolk");
        author.setEmail("eiqpejrpjq@gmail.com");
        author.setPhone("323-642-7483");
        author.setFirstName("Jalen");
        author.setLastName("Anthony");
        author.setState("CA");
        author.setStreet("743 Corprew Aveunue");
        author.setPostalCode("84892");
        author = authorRepository.save(author);

        Book book = new Book();
        book.setPublisherId(publisher.getId());
        book.setAuthorId(author.getId());
        book.setIsbn("9489438946");
        book.setTitle("The Rise");
        book.setPublishDate(LocalDate.of(1992, 5, 12));
        book.setPrice(new BigDecimal("12.98"));
        book = bookRepository.save(book);


        book = new Book();

        book.setPublisherId(publisher.getId());
        book.setAuthorId(author.getId());
        book.setIsbn("97654356846");
        book.setTitle("The Greatest Race");
        book.setPublishDate(LocalDate.of(2002, 12, 23));
        book.setPrice(new BigDecimal("12.98"));
        book = bookRepository.save(book);


        book = bookRepository.save(book);
        List<Book> bookList = bookRepository.findAll();
        assertEquals(bookList.size(), 2);
    }

}