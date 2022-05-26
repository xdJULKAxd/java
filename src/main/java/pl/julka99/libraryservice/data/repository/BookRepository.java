package pl.julka99.libraryservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.julka99.libraryservice.data.table.BookRecord;

public interface BookRepository extends JpaRepository<BookRecord,Integer> {


}
