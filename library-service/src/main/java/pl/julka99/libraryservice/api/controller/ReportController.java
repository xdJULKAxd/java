package pl.julka99.libraryservice.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.julka99.libraryservice.api.json.ReportCreateJson;
import pl.julka99.libraryservice.api.json.ReportJson;
import pl.julka99.libraryservice.client.ReportServiceClient;

import javax.servlet.http.HttpServletRequest;

@RestController()
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {
    private final ReportServiceClient reportServiceClient;

    public ReportController(ReportServiceClient reportServiceClient) {
        this.reportServiceClient = reportServiceClient;
    }

    @PostMapping("/reports")
    public ResponseEntity<String> createReport(HttpServletRequest request) {
        Integer userId = SessionUtil.getUserId(request);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .build();
        }
        String token = reportServiceClient.createReport(new ReportCreateJson(userId));
        if (token == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(token);
    }

    @GetMapping("/reports/{report-token}/status")
    public ResponseEntity<String> getReportStatus(@PathVariable("report-token") String token,
                                                  HttpServletRequest request) {
        Integer userId = SessionUtil.getUserId(request);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .build();
        }
        String reportStatus = reportServiceClient.getReportStatus(token);
        if (reportStatus == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity.ok(reportStatus);
    }


    @GetMapping("/reports/{report-token}")
    public ResponseEntity<ReportJson> getReport(@PathVariable("report-token") String token,
                                                HttpServletRequest request) {
        Integer userId = SessionUtil.getUserId(request);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .build();
        }
        ReportJson reportJson = reportServiceClient.getReport(token);
        if (reportJson == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity.ok(reportJson);
    }
}