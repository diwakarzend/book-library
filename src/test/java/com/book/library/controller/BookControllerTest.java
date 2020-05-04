package com.book.library.controller;

import com.book.library.dto.request.CreateBookRequestDto;
import com.book.library.dto.response.BookResponseDto;
import com.book.library.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class, secure = false)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;


    @Test
    public void testSaveBook() throws Exception{

        CreateBookRequestDto book =new CreateBookRequestDto();
        book.setId(1);
        book.setBookId("CS001");
        book.setNoOfPages(4000);
        book.setPublisherName("diwakar");
        book.setCategoryName("finance");
        book.setBookName("Global");

        String inputInJson= this.mapToJson(book);
        String URI= "/saveBook";

        Mockito.when(bookService.saveBook(Mockito.any(CreateBookRequestDto.class))).thenReturn(book);
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response=mvcResult.getResponse();
        String outputInJson=response.getContentAsString();
        assertEquals(outputInJson, inputInJson);
    }

    @Test
    public void testGetBookDetailByCategoryName() throws Exception{
        List<BookResponseDto> bookList =new ArrayList<>();
        BookResponseDto book=new BookResponseDto();
        book.setId(1);
        book.setBookId("CS001");
        book.setNoOfPages(4000);
        book.setPublisherName("diwakar");
        book.setCategoryName("finance");
        book.setBookName("Global");
        bookList.add(book);

        String URI= "/getBookBy/finance";
        Mockito.when(bookService.getBookDetailByCategoryName(Mockito.anyString())).thenReturn(bookList);
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
        String expextedJson=this.mapToJson(bookList);
        String outputInJson=mvcResult.getResponse().getContentAsString();
        assertEquals(outputInJson, expextedJson);
    }

    @Test
    public void testGetAllBooks() throws  Exception{
        List<BookResponseDto> bookList =new ArrayList<>();
        BookResponseDto book=new BookResponseDto();
        book.setId(1);
        book.setBookId("CS001");
        book.setNoOfPages(4000);
        book.setPublisherName("diwakar");
        book.setCategoryName("finance");
        book.setBookName("Global");
        bookList.add(book);

        book.setId(2);
        book.setBookId("CS002");
        book.setNoOfPages(430);
        book.setPublisherName("Thomas");
        book.setCategoryName("CS");
        book.setBookName("DS");
        bookList.add(book);

        String URI= "/getAllBooks";
        Mockito.when(bookService.getAllBooks()).thenReturn(bookList);
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
        String expextedJson=this.mapToJson(bookList);
        String outputInJson=mvcResult.getResponse().getContentAsString();
        assertEquals(outputInJson, expextedJson);

    }



    private String mapToJson(Object object) throws JsonProcessingException{
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}