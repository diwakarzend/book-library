package com.book.library.repository;

import com.book.library.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    List<BookEntity> findAllByCategoryName(String categoryName);

    @Query("SELECT distinct be.categoryName" + " FROM BookEntity be " + " ORDER BY be.categoryName")
    List<String> findAllGroupByCategoryName();
}
