package pl.julka99.reportsservice.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.julka99.reportsservice.api.json.*;
import pl.julka99.reportsservice.client.CustomerServiceClient;
import pl.julka99.reportsservice.client.LibraryServiceClient;
import pl.julka99.reportsservice.data.repository.ReportRepository;
import pl.julka99.reportsservice.data.table.ReportRecord;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final CustomerServiceClient customerServiceClient;
    private final LibraryServiceClient libraryServiceClient;

    public ReportService(ReportRepository reportRepository, CustomerServiceClient customerServiceClient,
                         LibraryServiceClient libraryServiceClient) {
        this.reportRepository = reportRepository;
        this.customerServiceClient = customerServiceClient;
        this.libraryServiceClient = libraryServiceClient;
    }

    public String createReport(ReportCreateJson reportCreateJson) {
        String token = UUID.randomUUID().toString();
        ReportRecord reportRecord = new ReportRecord(null, reportCreateJson.getUserId(), null,
                ReportStatus.NEW.name(), token, null);
        reportRepository.save(reportRecord);
        return token;
    }

    public ReportStatus getReportStatus(String token) {
        ReportRecord reportRecord = reportRepository.getByToken(token);
        if (reportRecord == null) {
            return null;
        }
        return ReportStatus.valueOf(reportRecord.getStatus());
    }

    public ReportJson getReport(String token) {
        ReportRecord reportRecord = reportRepository.getByToken(token);
        if (reportRecord == null || !reportRecord.getStatus().equals(ReportStatus.DONE.name())) {
            return null;
        }
        return new ReportJson(reportRecord.getName(), reportRecord.getContent());
    }

    @Scheduled(fixedDelay = 30000)
    public void generateReports() {
        List<ReportRecord> newReports = reportRepository.getAllByStatus(ReportStatus.NEW.name());
        for (ReportRecord newReport : newReports) {
            UserJson userJson = customerServiceClient.getUserById(newReport.getUserId());
            if (userJson == null) {
                continue;
            }
            BookRentStatusJson bookRentStatusJson = libraryServiceClient.getBookRents(userJson.getId());
            String content = "Wypożyczenia:\n";
            List<BookWithRentJson> bookRents = bookRentStatusJson.getBookRents();
            for (BookWithRentJson bookRent : bookRents) {
                content += String.format("- od %s do %s - author: %s title: %s description: %s \n",
                        formatDate(bookRent.getFrom()),
                        formatDate(bookRent.getTo()),
                        bookRent.getBookJson().getAuthor(),
                        bookRent.getBookJson().getTitle(),
                        bookRent.getBookJson().getDescription());
            }
            newReport.setContent(content);
            newReport.setName(userJson.getName());
            newReport.setStatus(ReportStatus.DONE.name());
            reportRepository.save(newReport);
        }
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        return sdf.format(date);
    }
}