package uk.oak.firstapi.Services;

import org.springframework.stereotype.Service;
import uk.oak.firstapi.Models.Book;
import uk.oak.firstapi.Repositories.BookRepository;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> getallbooks() {
        List<Book> list=bookRepository.findAll();
        return list;
    }

    @Override
    public Book getById(long id) {
        return bookRepository.findById(id).orElse(new Book());
    }

    @Override
    public Book update(Book book, long id) {
        Book frombd=bookRepository.findById(id).orElse(new Book());
        frombd.setBookName(book.getBookName());
        frombd.setIsbn(book.getIsbn());
        frombd.setAuthor(book.getAuthor());
        frombd.setYear(book.getYear());
        bookRepository.save(frombd);

        return frombd;
    }

    @Override
    public Book delete(long id) {
        Book book=bookRepository.findById(id).orElseThrow(()->new IllegalArgumentException());
        bookRepository.deleteById(id);
        return book;
    }
}
