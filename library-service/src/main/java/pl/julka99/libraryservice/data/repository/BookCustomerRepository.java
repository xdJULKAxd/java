package pl.julka99.libraryservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.julka99.libraryservice.data.table.BookCustomerRecord;

import java.util.Date;
import java.util.List;

public interface BookCustomerRepository extends JpaRepository<BookCustomerRecord, Integer> {
    boolean existsByBookIdAndFromLessThanEqualAndToGreaterThanEqual(Integer bookId, Date to, Date from);

    List<BookCustomerRecord> getAllByCustomerId(Integer customerId);


}