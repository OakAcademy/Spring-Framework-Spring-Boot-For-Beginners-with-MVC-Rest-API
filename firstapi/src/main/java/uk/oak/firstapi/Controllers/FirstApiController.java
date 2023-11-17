package uk.oak.firstapi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.oak.firstapi.Models.Book;
import uk.oak.firstapi.Services.BookService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class FirstApiController {
    public List<Book> bookList=new ArrayList<>();

    private final BookService bookService;

    public FirstApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getallbooks()
    {


//        return ResponseEntity.ok(bookList);
        return ResponseEntity.ok(bookService.getallbooks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getbyId(@PathVariable("id") long id)
    {
//        var list=bookList;
//        Book book=list.stream().filter(b->b.getId()==id).findFirst().orElse(null);
        Book book=bookService.getById(id);
        if(book!=null)
            return ResponseEntity.ok(book);
        else return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody Book book){
//        bookList.add(book);
//        return ResponseEntity.ok(book);
        return ResponseEntity.ok(bookService.addBook(book));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody Book book,@PathVariable("id")long id)
    {
//        List<Book> list=new ArrayList<>();
//        for(Book item:bookList)
//        {
//
//            if(item.getId()==id)
//            {
//                item.setYear(book.getYear());
//                item.setIsbn(book.getIsbn());
//                item.setAuthor(book.getAuthor());
//                item.setBookName(book.getBookName());
//            }
//            list.add(item);
//
//        }
//        bookList=list;
//        return ResponseEntity.ok(book);
        return ResponseEntity.ok(bookService.update(book,id));

    }
@DeleteMapping("/{id}")
public ResponseEntity<Book> deletebook(@PathVariable("id") long id)
{
//    List<Book> list=new ArrayList<>();
//    Book book=new Book();
//    for(Book item:bookList)
//    {
//        if(item.getId()==id)
//        {
//            book=item;
//        }
//        else
//            list.add(item);
//    }
//    bookList=list;
//    return ResponseEntity.ok(book);

    return ResponseEntity.ok(bookService.delete(id));
}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deletebook2 (@PathVariable("id") long id)
    {

        Book book=bookList.stream().filter(b->b.getId()==id).findFirst().orElse(null);
        if(book!=null) {
            bookList.remove(book);
        return ResponseEntity.ok(book);
        }
        else
            return new ResponseEntity(HttpStatus.FORBIDDEN);

    }

    @GetMapping("/fill")
    public ResponseEntity<List<Book>> allbookslist()
    {
        List<Book> list=new ArrayList<>();
        Book book1=new Book();
        book1.setId(1);
        book1.setBookName("book1");
        book1.setAuthor("author1");
        book1.setIsbn("isbn1");
        book1.setYear(2024);
        list.add(book1);
        Book book2=new Book();
        book2.setId(2);
        book2.setBookName("book2");
        book2.setAuthor("author2");
        book2.setIsbn("isbn2");
        book2.setYear(2024);
        list.add(book2);
        Book book3=new Book();
        book3.setId(3);
        book3.setBookName("book3");
        book3.setAuthor("author3");
        book3.setIsbn("isbn3");
        book3.setYear(2024);
        list.add(book3);
        Book book4=new Book();
        book4.setId(4);
        book4.setBookName("book4");
        book4.setAuthor("author4");
        book4.setIsbn("isbn4");
        book4.setYear(2024);
        list.add(book4);
        Book book5=new Book();
        book5.setId(5);
        book5.setBookName("book5");
        book5.setAuthor("author5");
        book5.setIsbn("isbn5");
        book5.setYear(2024);
        list.add(book5);
        Book book6=new Book();
        book6.setId(6);
        book6.setBookName("book6");
        book6.setAuthor("author6");
        book6.setIsbn("isbn6");
        book6.setYear(2024);
        list.add(book6);
        Book book7=new Book();
        book7.setId(7);
        book7.setBookName("book7");
        book7.setAuthor("author7");
        book7.setIsbn("isbn7");
        book7.setYear(2024);
        list.add(book7);
        Book book8=new Book();
        book8.setId(8);
        book8.setBookName("book8");
        book8.setAuthor("author8");
        book8.setIsbn("isbn8");
        book8.setYear(2024);
        list.add(book8);
        Book book9=new Book();
        book9.setId(9);
        book9.setBookName("book9");
        book9.setAuthor("author9");
        book9.setIsbn("isbn9");
        book9.setYear(2023);
        list.add(book9);
        Book book10=new Book();
        book10.setId(10);
        book10.setBookName("book10");
        book10.setAuthor("author10");
        book10.setIsbn("isbn10");
        book10.setYear(2024);
        list.add(book10);
        bookList=list;
        return ResponseEntity.ok(bookList);


    }


}
