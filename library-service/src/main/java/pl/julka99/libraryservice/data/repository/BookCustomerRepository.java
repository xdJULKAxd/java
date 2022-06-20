package pl.julka99.libraryservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.julka99.libraryservice.data.table.BookCustomerRecord;
import pl.julka99.libraryservice.data.table.BookRecord;

import java.util.Date;

public interface BookCustomerRepository extends JpaRepository<BookCustomerRecord,Integer> {
    boolean existsByBookIdAndFromLessThanEqualAndToGreaterThanEqual(Integer bookId, Date to, Date from);


}
