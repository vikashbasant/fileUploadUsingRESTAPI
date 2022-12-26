package com.api.book.bootrestbook.dao;

import com.api.book.bootrestbook.model.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer>{
    
}
