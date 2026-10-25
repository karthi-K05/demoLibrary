package com.example.demoLibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoLibrary.entity.Author;
import com.example.demoLibrary.entity.Book;
import com.example.demoLibrary.repository.AuthorRepository;
import com.example.demoLibrary.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepo;
	@Autowired
	private AuthorRepository authorRepo;

	@Autowired
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	public void addBook(Book book) {

	    Integer authorId = book.getAuthor().getId();

	    Author author = authorRepo.findById(authorId)
	            .orElseThrow(() -> new RuntimeException("Author not found"));

	    book.setAuthor(author);

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

	@Transactional
	public void updateBookById(int id, Book book) {
		Book b = getBookById(id);
		b.setTitle(book.getTitle());
		Author a = authorRepo.findById(b.getAuthor().getId()).orElseThrow(() -> new RuntimeException(
									"Author not found" + b.getAuthor().getId()));
		b.setAuthor(a);
	}

}
