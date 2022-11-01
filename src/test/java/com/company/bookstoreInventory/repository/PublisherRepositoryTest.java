package com.company.bookstoreInventory.repository;

import com.company.bookstoreInventory.model.Publisher;
import com.company.bookstoreInventory.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {

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
    public void addGetDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setCity("Suffolk");
        publisher.setEmail("justindildy18@gmail.com");
        publisher.setName("Justin");
        publisher.setState("Virginia");
        publisher.setStreet("700 Park Avenue");
        publisher.setPhone("999-324-3831");
        publisher.setPostalCode("23230");
        publisher = publisherRepository.save(publisher);

        Author author = new Author();
        author.setCity("Norfolk");
        author.setEmail("eiqpejrpjq@gmail.com");
        author.setPhone("323-642-7483");
        author.setFirstName("Jalen");
        author.setLastName("Anthony");
        author.setState("California");
        author.setStreet("743 Corprew Aveunue");
        author.setPhone("84892");
        author = authorRepository.save(author);

        publisher = publisherRepository.save(publisher);

        Optional<Publisher> publisherOptional = publisherRepository.findById(publisher.getId());

        assertEquals(publisherOptional.get(), publisher);

        publisherRepository.deleteById(publisher.getId());

        publisherOptional = publisherRepository.findById(publisher.getId());

        assertFalse(publisherOptional.isPresent());



    }
}