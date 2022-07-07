package pl.julka99.libraryservice.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.julka99.libraryservice.api.json.ReportCreateJson;
import pl.julka99.libraryservice.api.json.ReportJson;

import java.net.URI;

@Service
public class ReportServiceClient {
    private RestTemplate restTemplate;

    public ReportServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String createReport(ReportCreateJson reportCreateJson) {
        try {
            String url = UriComponentsBuilder.newInstance()
                    .uri(new URI("http://localhost:8083/reports"))
                    .build().toString();
            ParameterizedTypeReference<String> ptr = new ParameterizedTypeReference<String>() {
            };
            return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(reportCreateJson), ptr).getBody();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public String getReportStatus(String token) {
        try {
            String url = UriComponentsBuilder.newInstance()
                    .uri(new URI("http://localhost:8083/reports/" + token + "/status"))
                    .build().toString();
            ParameterizedTypeReference<String> ptr = new ParameterizedTypeReference<String>() {
            };
            return restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, ptr).getBody();

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public ReportJson getReport(String token) {
        try {
            String url = UriComponentsBuilder.newInstance()
                    .uri(new URI("http://localhost:8083/reports/" + token))
                    .build().toString();
            ParameterizedTypeReference<ReportJson> ptr = new ParameterizedTypeReference<ReportJson>() {
            };
            return restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, ptr).getBody();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

}