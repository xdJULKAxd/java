package pl.julka99.libraryservice.client;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import pl.julka99.libraryservice.api.json.UserJson;

import java.net.URI;

@Service
public class CustomerServiceClient {
    public UserJson getUserByEmail(String email){
        try {
            String url = UriComponentsBuilder.newInstance()
                    .uri(new URI("http://localhost:8081/users/by-email"))
                    .queryParam("email",email)
                    .build().toString();
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

}
