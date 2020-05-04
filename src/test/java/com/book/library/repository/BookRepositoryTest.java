package com.book.library.repository;

import com.book.library.model.BookEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class BookRepositoryTest {

      @Autowired
      private TestEntityManager entityManager;

      @Autowired
      private BookRepository bookRepository;

      @Test
      public void testSaveBook(){
          BookEntity book =getBookDetails();
          BookEntity savedInDb =entityManager.persist(book);
          BookEntity getFromDb=bookRepository.getOne(savedInDb.getId());
          assertEquals(getFromDb, savedInDb);
      }

      private BookEntity getBookDetails(){
          BookEntity book =new BookEntity();
           book.setBookId("CS001");
           book.setNoOfPages(4000);
           book.setPublisherName("diwakar");
           book.setCategoryName("finance");
           book.setBookName("Global");
           return book;
      }




}