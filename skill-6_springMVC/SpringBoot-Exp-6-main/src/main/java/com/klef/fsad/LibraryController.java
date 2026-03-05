package com.klef.fsad;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {


    private List<Book> bookList = new ArrayList<>();

    // 1. Welcome
    @GetMapping("/")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    // 2. Count
    @GetMapping("/count")
    public int countBooks() {
        return bookList.size();
    }

    // 3. Sample Price
    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    // 4. Get Book Titles
    @GetMapping("/books")
    public List<String> getBooks() {
        List<String> titles = new ArrayList<>();
        for (Book b : bookList) {
            titles.add(b.title);
        }
        return titles;
    }

    // 5. Get Book by ID (PathVariable)
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        for (Book b : bookList) {
            if (b.id.equals(id)) {
                return b;
            }
        }
        return null;
    }

    // 6. Search using RequestParam
    @GetMapping("/search")
    public String searchBook(@RequestParam("title") String title) {
        return "Searching for book: " + title;
    }

    // 7. Author using PathVariable
    @GetMapping("/author/{name}")
    public String authorName(@PathVariable("name") String name) {
        return "Books written by: " + name;
    }

    // 8. Add Book using POST
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book Added Successfully";
    }

    // 9. View All Books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }

    // Inner Class (No Separate Entity File)
    public static class Book {
        public Long id;
        public String title;
        public String author;
        public double price;
    }
}

