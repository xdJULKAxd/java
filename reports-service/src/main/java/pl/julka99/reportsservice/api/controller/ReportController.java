package pl.julka99.reportsservice.api.controller;

import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.julka99.reportsservice.api.json.ReportCreateJson;
import pl.julka99.reportsservice.api.json.ReportJson;
import pl.julka99.reportsservice.service.ReportService;
import pl.julka99.reportsservice.service.ReportStatus;

import javax.validation.Valid;

@Validated
@RestController()
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/reports")
    public ResponseEntity<String> createReport(@RequestBody @Valid ReportCreateJson reportCreateJson) {

        String token = reportService.createReport(reportCreateJson);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(token);
    }

    @GetMapping("/reports/{report-token}/status")
    public ResponseEntity<String> getReportStatus(@PathVariable("report-token") String token) {
        ReportStatus reportStatus = reportService.getReportStatus(token);
        if (reportStatus == null) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(reportStatus.name());
    }


    @GetMapping("/reports/{report-token}")
    public ResponseEntity<ReportJson> getReport(@PathVariable("report-token") String token) {
        ReportJson reportJson = reportService.getReport(token);
        if (reportJson == null) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(reportJson);
    }

}
