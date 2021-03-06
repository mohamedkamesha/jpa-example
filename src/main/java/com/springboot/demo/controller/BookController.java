package com.springboot.demo.controller;

import com.springboot.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public String getBooks(Model model){
        model.addAttribute("books",bookRepository.findAll());
        return  "books";
    }
}
