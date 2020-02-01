package com.in28minutes.springboot.basics.sprintbootin10steps.BookEntry;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return Arrays.asList(new Book(1l,"Mastering Spring 5.1","Ankita Srivastava"), new Book(2l,"Basics of JAVA","Pankaj Kumar Yadav"));
	}
}
