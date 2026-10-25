package com.example.demoLibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demoLibrary.entity.Author;
import com.example.demoLibrary.repository.AuthorRepository;

@Service
public class AuthorService {

	private AuthorRepository authorRepo;

	@Autowired
	public AuthorService(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
	}
	
	public void addAuthor(Author author) {
		String name = author.getName() != null ? author.getName().trim() : "";
		
		if(name.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author name is required");
		}
		if(authorRepo.existsByNameIgnoreCase(name)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Author already exists: " + name);
		}
		if(author.getBooks() != null) {
			author.getBooks().forEach(b -> b.setAuthor(author));
		}
		authorRepo.save(author);
	}

	public Author getAuthorById(int authorId) {
		return authorRepo.findById(authorId).orElse(null);
		
	}

	public List<Author> getAuthors() {
		return authorRepo.findAll();
	}

	public void deleteAuthorById(int authorId) {
		authorRepo.deleteById(authorId);
	}
}
