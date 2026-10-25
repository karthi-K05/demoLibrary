package com.example.demoLibrary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoLibrary.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
	boolean existsByNameIgnoreCase(String name);
	
	Optional<Author> findByNameIgnoreCase(String name);

}
