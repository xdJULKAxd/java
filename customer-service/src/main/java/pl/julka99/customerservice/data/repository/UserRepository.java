package pl.julka99.customerservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.julka99.customerservice.data.table.UserRecord;

public interface UserRepository extends JpaRepository<UserRecord,Integer> {
    UserRecord getByEmail(String email);
    UserRecord getById(Integer id);
}
