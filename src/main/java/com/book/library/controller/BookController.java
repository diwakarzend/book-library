package com.book.library.controller;

import com.book.library.dto.request.CreateBookRequestDto;
import com.book.library.dto.response.BookResponseDto;
import com.book.library.dto.response.LibraryResponseDto;
import com.book.library.model.BookEntity;
import com.book.library.repository.BookRepository;
import com.book.library.service.BookService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/saveBook")
    public CreateBookRequestDto saveBook(@RequestBody CreateBookRequestDto createBookRequestDto){
        return bookService.saveBook(createBookRequestDto);
    }

    @GetMapping("/getAllBooks")
    public List<BookResponseDto> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookBy/{categoryName}")
    public List<BookResponseDto> getBookDetailByCategoryName(@PathVariable String categoryName){
        return bookService.getBookDetailByCategoryName(categoryName);
    }

    @PutMapping("/updateBook")
    public CreateBookRequestDto saveOrUpdateBook(@RequestBody CreateBookRequestDto createBookRequestDto){
        return bookService.saveBook(createBookRequestDto);
    }


    @GetMapping("/getlibrary")
    public List<LibraryResponseDto> getLibraryList(){
        return bookService.getLibraryList();
    }






}
