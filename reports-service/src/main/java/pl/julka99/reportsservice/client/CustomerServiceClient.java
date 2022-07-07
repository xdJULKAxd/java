package pl.julka99.reportsservice.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.julka99.reportsservice.api.json.UserJson;

import java.net.URI;

@Service
public class CustomerServiceClient {
    private RestTemplate restTemplate;

    public CustomerServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public UserJson getUserById(Integer id) {
        try {
            String url = UriComponentsBuilder.newInstance()
                    .uri(new URI("http://localhost:8082/users/by-id"))
                    .queryParam("id", id)
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