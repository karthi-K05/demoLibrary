package com.example.demoLibrary.contoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoLibrary.dto.BookDTO;
import com.example.demoLibrary.entity.Book;
import com.example.demoLibrary.service.BookService;

@RestController
@RequestMapping("api/library/books")
public class BookController {
	
	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return ResponseEntity.ok("Book Added Successfully");
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<BookDTO> getBookById(@PathVariable int bookId){
		Book b = bookService.getBookById(bookId);
		BookDTO bookDTO = new BookDTO(b.getId(), b.getTitle(), b.getAuthor().getName());
		return ResponseEntity.ok(bookDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<BookDTO>> getBooks(){
		List<Book> books = bookService.getBooks();
		List<BookDTO> booksDTO = books.stream()
									  .map(b -> new BookDTO(
											  b.getId(), 
											  b.getTitle(), 
											  b.getAuthor() != null ? b.getAuthor().getName() : null))
									  .toList();
		return ResponseEntity.ok(booksDTO);
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> deleteBookById(@PathVariable int bookId){
		bookService.deleteBookById(bookId);
		return ResponseEntity.ok("Book Deleted Successfully");
	}
	
	@PutMapping("/{bookId}")
	public ResponseEntity<String> updateBookById(@PathVariable int bookId, @RequestBody Book book) {
		bookService.updateBookById(bookId, book);
		return ResponseEntity.accepted().body("Book Updated Successfully");
	}
}
