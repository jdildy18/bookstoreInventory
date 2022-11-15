package com.company.bookstoreInventory.repository;

import com.company.bookstoreInventory.model.Author;
import com.company.bookstoreInventory.model.Publisher;
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
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;



    @Before
    public void setUp() throws Exception {
        authorRepository.deleteAll();

    }

    @Test
    public void addGetDeleteAuthor() {

        Author author = new Author();
        author.setCity("Norfolk");
        author.setEmail("eiqpejrpjq@gmail.com");
        author.setPhone("323-642-7483");
        author.setFirstName("Jaylen");
        author.setLastName("Anthony");
        author.setState("CA");
        author.setStreet("743 Corprew Avenue");
        author.setPostalCode("84892");
        author = authorRepository.save(author);


        Optional<Author> author1 = authorRepository.findById(author.getId());

        assertEquals(author1.get(), author);

        authorRepository.deleteById(author.getId());

        author1 = authorRepository.findById(author.getId());

        assertFalse(author1.isPresent());
    }


    @Test
    public void getAllAuthors() {

        Author author = new Author();
        author.setPostalCode("83829");
        author.setPhone("282-757-7381");
        author.setCity("Richmond");
        author.setLastName("Nick");
        author.setFirstName("Jasper");
        author.setEmail("eidfsoapijdf@yahoo.com");
        author.setStreet("Melbrook Pkwy");
        author.setState("ID");

        authorRepository.save(author);

        author = new Author();
        author.setPostalCode("49731");
        author.setPhone("837-548-8251");
        author.setCity("Harrisonburg");
        author.setLastName("Jackson");
        author.setFirstName("Solomon");
        author.setEmail("i490su43f@hotmail.com");
        author.setStreet("Oxnard Dr");
        author.setState("CA");

        author = authorRepository.save(author);

        List<Author> authorList = authorRepository.findAll();
        assertEquals(authorList.size(), 2);





    }
    @Test
    public void updateAuthor() {
        Author author = new Author();
        author.setPostalCode("83829");
        author.setPhone("282-757-7381");
        author.setCity("Richmond");
        author.setLastName("Nick");
        author.setFirstName("Jasper");
        author.setEmail("eidfsoapijdf@yahoo.com");
        author.setStreet("Melbrook Pkwy");
        author.setState("ID");
        authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getId());
        assertEquals(author1.get(), author);
    }



}