package com.book.library.service;

import com.book.library.dto.request.CreateBookRequestDto;
import com.book.library.dto.response.BookResponseDto;
import com.book.library.dto.response.LibraryResponseDto;

import java.util.List;

public interface BookService {

    CreateBookRequestDto saveBook(CreateBookRequestDto createBookRequestDto);

    List<BookResponseDto> getAllBooks();

    List<BookResponseDto> getBookDetailByCategoryName( String categoryName);

    List<LibraryResponseDto> getLibraryList();

}
