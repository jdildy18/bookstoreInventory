package com.company.bookstoreInventory.repository;

import com.company.bookstoreInventory.model.Publisher;
import com.company.bookstoreInventory.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {

//    @Autowired
//    BookRepository bookRepository;
//    @Autowired
//    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        //  bookRepository.deleteAll();
        publisherRepository.deleteAll();


    }

    @Test
    public void addGetDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setCity("Suffolk");
        publisher.setEmail("justindildy18@gmail.com");
        publisher.setName("Justin");
        publisher.setState("AL");
        publisher.setStreet("700 Park Avenue");
        publisher.setPhone("999-324-3831");
        publisher.setPostalCode("23230");
        publisher = publisherRepository.save(publisher);


        publisher = publisherRepository.save(publisher);

        Optional<Publisher> publisherOptional = publisherRepository.findById(publisher.getId());

        assertEquals(publisherOptional.get() , publisher);

        publisherRepository.deleteById(publisher.getId());

        publisherOptional = publisherRepository.findById(publisher.getId());

        assertFalse(publisherOptional.isPresent());



    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Josh Jacobs");
        publisher.setCity("Baltimore");
        publisher.setPhone("173-732-8365");
        publisher.setEmail("bidapdje@aol.com");
        publisher.setStreet("Ventura Ave");
        publisher.setState("OR");
        publisher.setPostalCode("38492");

        publisher = publisherRepository.save(publisher);

        publisher = new Publisher();
        publisher.setName("Jake Florence");
        publisher.setCity("Atlanta");
        publisher.setPhone("183-745-9437");
        publisher.setEmail("u4h9348d@gmail.com");
        publisher.setStreet("Anaheim Rd");
        publisher.setState("WA");
        publisher.setPostalCode("08472");

        publisher = publisherRepository.save(publisher);
        List<Publisher> publisherList = publisherRepository.findAll();
        assertEquals(publisherList.size(), 2);

    }

    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Josh Jacobs");
        publisher.setCity("Baltimore");
        publisher.setPhone("173-732-8365");
        publisher.setEmail("bidapdje@aol.com");
        publisher.setStreet("Ventura Ave");
        publisher.setState("OR");
        publisher.setPostalCode("38492");

        publisher = publisherRepository.save(publisher);

        publisher.setName("Jake Florence");
        publisher.setCity("Atlanta");
        publisher.setPhone("183-745-9437");
        publisher.setEmail("u4h9348d@gmail.com");
        publisher.setStreet("Anaheim Rd");
        publisher.setState("WA");
        publisher.setPostalCode("08472");

        publisherRepository.save(publisher);

        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());
        assertEquals(publisher1.get(), publisher);


    }
}