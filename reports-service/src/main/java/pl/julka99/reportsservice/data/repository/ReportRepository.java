package pl.julka99.reportsservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.julka99.reportsservice.data.table.ReportRecord;

import java.util.List;

public interface ReportRepository extends JpaRepository<ReportRecord, Integer> {
    ReportRecord getByToken(String token);

    List<ReportRecord> getAllByStatus(String status);
}