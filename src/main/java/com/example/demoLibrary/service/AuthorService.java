package com.example.demoLibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
