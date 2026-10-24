package com.example.demoLibrary.dto;

import java.util.List;

import com.example.demoLibrary.entity.Book;

public record AuthorDTO(int id, String name, List<String> bookTitle){

}
