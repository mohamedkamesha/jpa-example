package com.springboot.demo.bootsrap;

import com.springboot.demo.model.Author;
import com.springboot.demo.model.Book;
import com.springboot.demo.model.Publisher;
import com.springboot.demo.repositories.AuthorRepository;
import com.springboot.demo.repositories.BookRepository;
import com.springboot.demo.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publicherRepository;

  /*  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }*/

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData (){
        Publisher publisher = new Publisher("fooo","landon");
        publicherRepository.save(publisher);

        Author author = new Author("mohamed","mahmoud");
        Book book = new Book("java","k123",publisher);
        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);


        Author author2 = new Author("kamesha","komesho");
        Book book2 = new Book("php","var",publisher);
        author2.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);


    }
}
