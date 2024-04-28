package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Books;
import com.test.SpringBootApi.respository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public Books save(Books books) {
        try {
            return booksRepository
                    .save(
                    new Books(
                            books.getBookName(),
                            books.getPrice(),
                            books.getWriter()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Optional<Books> findById(Long id) {
        try {
            Optional<Books> bookData = booksRepository.findById(id);
            if (bookData.isPresent()) {
                return bookData;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Books update(Long id, Books books) {

        try {
            Optional<Books> bookData = booksRepository.findById(id);
            if (bookData.isPresent()) {
                Books _books = bookData.get();
                _books.setBookName(books.getBookName());
                _books.setPrice(books.getPrice());
                _books.setWriter(books.getWriter());
                booksRepository.save(_books);
                return _books;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            booksRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
