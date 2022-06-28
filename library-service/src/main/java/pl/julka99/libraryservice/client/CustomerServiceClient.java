package pl.julka99.libraryservice.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.julka99.libraryservice.api.json.UserJson;


import java.net.URI;

@Service
public class CustomerServiceClient {
    private RestTemplate restTemplate;

    public CustomerServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public UserJson getUserByEmail(String email) {
        try {
            String url = UriComponentsBuilder.newInstance()
                    .uri(new URI("http://localhost:8082/users/by-email"))
                    .queryParam("email", email)
                    .build().toString();
            ParameterizedTypeReference<UserJson> ptr = new ParameterizedTypeReference<UserJson>() {
            };
            return restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, ptr).getBody();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

}
