package com.example.demoLibrary.contoller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoLibrary.dto.AuthorDTO;
import com.example.demoLibrary.entity.Author;
import com.example.demoLibrary.service.AuthorService;

@RestController
@RequestMapping("api/library/authors")
public class AuthorController {

	private AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@PostMapping
	public ResponseEntity<String> addAuthor(@RequestBody Author author) {
		authorService.addAuthor(author);
		return ResponseEntity.ok("Author Added Successfully");
	}
	
	@GetMapping("/{authorId}")
	public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable int authorId){
		Author author = authorService.getAuthorById(authorId);
		
		AuthorDTO authorDTO = new AuthorDTO(author.getId(), author.getName(), author.getBooks().stream()
								.map(a -> a.getTitle())
								.toList());
		return ResponseEntity.ok(authorDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<AuthorDTO>> getAuthors(){
		List<Author> authors = authorService.getAuthors();
		List<AuthorDTO> authorsDTO = authors.stream()
									.map(a -> new AuthorDTO(
											a.getId(), 
											a.getName(), 
											a.getBooks() != null 
													? a.getBooks().stream()
													.map(b -> b.getTitle())
													.toList() : List.of()))
									.toList();
		return ResponseEntity.ok(authorsDTO);
	}
	
	@DeleteMapping("/{authorId}")
	public ResponseEntity<String> deleteauthorById(@PathVariable int authorId){
		authorService.deleteAuthorById(authorId);
		return new ResponseEntity<String>("Author Deleted Successfully", HttpStatus.OK);
	}
}
