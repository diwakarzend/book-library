package com.book.library.util;

import com.book.library.dto.request.CreateBookRequestDto;
import com.book.library.dto.response.BookResponseDto;
import com.book.library.dto.response.LibraryResponseDto;
import com.book.library.model.BookEntity;

import java.util.ArrayList;
import java.util.List;

public class BookUtil {


    public static BookEntity mapBookRequest(CreateBookRequestDto createBookRequestDto){
        BookEntity bookEntity=new BookEntity();
        bookEntity.setId(createBookRequestDto.getId());
        bookEntity.setBookId(createBookRequestDto.getBookId());
        bookEntity.setBookName(createBookRequestDto.getBookName());
        bookEntity.setCategoryName(createBookRequestDto.getCategoryName());
        bookEntity.setPublisherName(createBookRequestDto.getPublisherName());
        bookEntity.setNoOfPages(createBookRequestDto.getNoOfPages());
        return  bookEntity;
    }


    public static List<BookResponseDto> mapBookResponse(List<BookEntity> bookEntities){
        List<BookResponseDto> bookResponseDto=new ArrayList<>();
        if(!bookEntities.isEmpty()){
            bookEntities.forEach(e -> {
                BookResponseDto bookDto= mapBookResponseById(e);
                bookResponseDto.add(bookDto);
            });
            return bookResponseDto;
        }
      return bookResponseDto;
    }

    public static BookResponseDto mapBookResponseById(BookEntity bookEntity) {
        BookResponseDto bookDto = new BookResponseDto();
        bookDto.setId(bookEntity.getId());
        bookDto.setBookId(bookEntity.getBookId());
        bookDto.setBookName(bookEntity.getBookName());
        bookDto.setCategoryName(bookEntity.getCategoryName());
        bookDto.setPublisherName(bookEntity.getPublisherName());
        bookDto.setNoOfPages(bookEntity.getNoOfPages());
        return  bookDto;
    }


    public static List<LibraryResponseDto> libraryResponse(List<String> bookEntities){
        List<LibraryResponseDto> libraryResponseDtos=new ArrayList<>();
        if(!bookEntities.isEmpty()){
            bookEntities.forEach(e -> {
                LibraryResponseDto libraryDto=new LibraryResponseDto();
                libraryDto.setCategoryName(e);
                libraryResponseDtos.add(libraryDto);
            });
            return libraryResponseDtos;
        }
        return libraryResponseDtos;
    }
}
