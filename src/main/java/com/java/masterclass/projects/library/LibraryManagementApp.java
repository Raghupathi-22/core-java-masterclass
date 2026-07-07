package com.java.masterclass.projects.library;

import java.util.*;

public final class LibraryManagementApp {
    private LibraryManagementApp() {}

    public record Book(String isbn, String title, boolean issued) {}

    public static final class LibraryService {
        private final Map<String, Book> books = new HashMap<>();

        public void addBook(String isbn, String title) {
            books.put(isbn, new Book(isbn, title, false));
        }

        public boolean issueBook(String isbn) {
            Book b = books.get(isbn);
            if (b == null || b.issued()) return false;
            books.put(isbn, new Book(b.isbn(), b.title(), true));
            return true;
        }

        public boolean returnBook(String isbn) {
            Book b = books.get(isbn);
            if (b == null || !b.issued()) return false;
            books.put(isbn, new Book(b.isbn(), b.title(), false));
            return true;
        }
    }
}
