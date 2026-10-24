package com.example.demoLibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoLibrary.entity.Book;
import com.example.demoLibrary.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepo;

	@Autowired
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	public void addBook(Book book) {
		bookRepo.save(book);
	}

	public Book getBookById(int bookId) {
		return bookRepo.findById(bookId).orElse(null);
		
	}

	public List<Book> getBooks() {
		return bookRepo.findAll();
	}

	public void deleteBookById(int bookId) {
		bookRepo.deleteById(bookId);
	}

//	public void updateBook(Book book) {
//		Optional<Book> book1 = bookRepo.findById(book.getId());
//		book
//	}
	
	
}
