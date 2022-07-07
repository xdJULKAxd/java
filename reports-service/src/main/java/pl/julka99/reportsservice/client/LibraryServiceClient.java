package pl.julka99.reportsservice.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.julka99.reportsservice.api.json.BookRentStatusJson;

import java.net.URI;

@Service
public class LibraryServiceClient {
    private RestTemplate restTemplate;

    public LibraryServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BookRentStatusJson getBookRents(Integer userId) {
        try {
            String url = UriComponentsBuilder.newInstance()
                    .uri(new URI("http://localhost:8081/book/rent"))
                    .queryParam("user-id", userId)
                    .build().toString();
            ParameterizedTypeReference<BookRentStatusJson> ptr = new ParameterizedTypeReference<BookRentStatusJson>() {
            };
            return restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, ptr).getBody();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

}