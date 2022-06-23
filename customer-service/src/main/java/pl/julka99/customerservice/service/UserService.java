package pl.julka99.customerservice.service;

import org.springframework.stereotype.Service;
import pl.julka99.customerservice.api.json.UserCreateJson;
import pl.julka99.customerservice.api.json.UserJson;
import pl.julka99.customerservice.data.repository.UserRepository;
import pl.julka99.customerservice.data.table.UserRecord;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserCreateJson userCreateJson) {
        UserRecord userRecord = new UserRecord(null, userCreateJson.getName(),
                userCreateJson.getEmail(), userCreateJson.getPassword());
        userRepository.save(userRecord);
    }

    public void deleteUser(Integer id) {
        boolean existUser = userRepository.existsById(id);
        if (existUser) {
            userRepository.deleteById(id);
        }

    }
    public UserJson getByEmail(String email){

        UserRecord userRecord = userRepository.getByEmail(email);
        if(userRecord == null){
            return null;

        }else {
            return new UserJson(userRecord.getId(),userRecord.getName(),
                    userRecord.getEmail(), userRecord.getPassword());
        }
    }
    public UserJson getById( Integer id ){
        UserRecord userRecord = userRepository.getById(id);
        if(userRecord == null){
            return null;

        }else {
            return new UserJson(userRecord.getId(),userRecord.getName(),
                    userRecord.getEmail(), userRecord.getPassword());
        }


    }

}
