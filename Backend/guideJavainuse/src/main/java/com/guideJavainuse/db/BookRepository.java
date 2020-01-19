package com.guideJavainuse.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guideJavainuse.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
