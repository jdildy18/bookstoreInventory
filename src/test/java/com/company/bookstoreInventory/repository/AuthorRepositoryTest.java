package com.company.bookstoreInventory.repository;

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
        author.setFirstName("Jalen");
        author.setLastName("Anthony");
        author.setState("California");
        author.setStreet("743 Corprew Aveunue");
        author.setPostalCode("84892");

        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getId());

        assertEquals(author1.get(), author);

        authorRepository.deleteById(author.getId());

        author1 = authorRepository.findById(author.getId());

        assertFalse(author1.isPresent());
    }
}