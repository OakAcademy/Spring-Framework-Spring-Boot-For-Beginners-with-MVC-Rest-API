package uk.oak.firstapi.Services;

import uk.oak.firstapi.Models.Book;

import java.util.List;

public interface BookService {
    public Book addBook(Book book);
    public List<Book> getallbooks();
    public Book getById(long id);
    public Book update(Book book,long id);
    public Book delete(long id);
}
