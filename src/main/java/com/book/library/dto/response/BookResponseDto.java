package com.book.library.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookResponseDto {
        private int id;
        private String bookId;
        private String bookName;
        private String publisherName;
        private String categoryName;
        private Number noOfPages;
}
