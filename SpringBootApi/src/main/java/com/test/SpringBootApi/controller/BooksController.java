package com.test.SpringBootApi.controller;

import com.test.SpringBootApi.service.BooksServiceImpl;
import com.test.SpringBootApi.domain.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BooksController {

    @Autowired
    BooksServiceImpl BooksService;

    @GetMapping("/books/{id}")
    public ResponseEntity<Optional<Books>> getProductById(@PathVariable("id") long id) {

        try {
            return ResponseEntity.ok(BooksService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/books")
    public ResponseEntity<Books> createProduct(@RequestBody Books books) {
        try {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(BooksService.save(books));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Books> updateProduct(
            @PathVariable("id") long id,
            @RequestBody Books books
    ) {
        try {
            ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(BooksService.update(id, books));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
        try {
            BooksService.delete(id);
            ResponseEntity.noContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
