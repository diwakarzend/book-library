package com.book.library.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequestDto {
    private int Id;
    private String bookId;
    private String bookName;
    private String publisherName;
    private String categoryName;
    private Number noOfPages;
}
