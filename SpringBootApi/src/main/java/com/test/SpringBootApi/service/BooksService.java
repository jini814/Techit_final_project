package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Books;

import java.util.Optional;

public interface BooksService {

    public Books save(Books books);
    public Optional<Books> findById(Long id);
    //Null 값을 넘길 때 optional이 처리할 수 있도록
    public Books update(Long id, Books books);
    //수정하면 내용 덮어쓰기
    public void delete(Long id);

}
