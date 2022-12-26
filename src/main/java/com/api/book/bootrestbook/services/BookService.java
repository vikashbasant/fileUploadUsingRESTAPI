package com.api.book.bootrestbook.services;

import java.util.List;
import java.util.Optional;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // @Component both are same till now:
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    // get all book:
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>)bookRepository.findAll();
        return list;
    }


    // get single book by Id:
    public Book getBookById(int id) {
        Book book = new Book();
        
        try {
            Optional<Book> b = bookRepository.findById(id);
            b.ifPresent(temp -> {
                book.setId(temp.getId());
                book.setTitle(temp.getTitle());
                book.setAuthor(temp.getAuthor());
            });
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return book;
        
    }


    // adding the book
    public Book addBook(Book b) {
        bookRepository.save(b);
        return b;
    }


    // deleting the book
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }


    // updating the book
    public void updateBook(Book book, int id) {
        book.setId(id);
        bookRepository.save(book);
        
    }
}
