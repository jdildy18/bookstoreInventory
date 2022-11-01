package com.company.bookstoreInventory.controller;

import com.company.bookstoreInventory.model.Publisher;
import com.company.bookstoreInventory.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {
    @Autowired
    PublisherRepository repo;

    @GetMapping("/publishers")
    public List<Publisher> getPublishers() { return repo.findAll();}

    @GetMapping("publishers/{id}")
    public Publisher getPublisherById(@PathVariable int id) {
        Optional<Publisher> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }


    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher) { return repo.save(publisher); }

    @PutMapping("/publisher")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher) { repo.save(publisher);}

    @DeleteMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id) { repo.deleteById(id); }
}
