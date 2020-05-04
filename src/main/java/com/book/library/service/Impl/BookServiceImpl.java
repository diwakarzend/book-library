package com.book.library.service.Impl;

import com.book.library.dto.request.CreateBookRequestDto;
import com.book.library.dto.response.BookResponseDto;
import com.book.library.dto.response.LibraryResponseDto;
import com.book.library.model.BookEntity;
import com.book.library.repository.BookRepository;
import com.book.library.service.BookService;
import com.book.library.util.BookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    public CreateBookRequestDto saveBook(CreateBookRequestDto createBookRequestDto){
        CreateBookRequestDto createDto=new CreateBookRequestDto();
        if(Objects.nonNull(createBookRequestDto)){
            BookEntity bookEntity = BookUtil.mapBookRequest(createBookRequestDto);
            bookRepository.save(bookEntity);
            createDto.setBookId(bookEntity.getBookId());
            createDto.setBookName(bookEntity.getBookName());
            createDto.setCategoryName(bookEntity.getCategoryName());
            return createDto;
        }
        return createDto;
    }

    public List<BookResponseDto> getAllBooks(){
       List<BookEntity> bookEntities= bookRepository.findAll();
        List<BookResponseDto> bookResponseDtos = BookUtil.mapBookResponse(bookEntities);
        return bookResponseDtos;
    }

    public List<BookResponseDto> getBookDetailByCategoryName(String categoryName){
        List<BookEntity> bookEntity= bookRepository.findAllByCategoryName(categoryName);
        List<BookResponseDto> bookResponseDto = BookUtil.mapBookResponse(bookEntity);
        return bookResponseDto;
    }

    public List<LibraryResponseDto> getLibraryList(){
        List<String> bookEntity=bookRepository.findAllGroupByCategoryName();
        List<LibraryResponseDto> libraryResponseDtos = BookUtil.libraryResponse(bookEntity);
        return libraryResponseDtos;
    }

}
