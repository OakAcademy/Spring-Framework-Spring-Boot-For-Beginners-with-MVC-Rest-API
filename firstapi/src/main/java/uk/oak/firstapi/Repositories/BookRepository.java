package uk.oak.firstapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.oak.firstapi.Models.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
