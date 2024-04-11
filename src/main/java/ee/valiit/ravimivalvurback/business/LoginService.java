package ee.valiit.ravimivalvurback.business;

import ee.valiit.ravimivalvurback.domain.user.LoginResponse;
import ee.valiit.ravimivalvurback.domain.user.User;
import ee.valiit.ravimivalvurback.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private UserRepository userRepository;

    public void login(String username, String password) {
        User user = userRepository.findAuthorizedUser(username, password);


        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(user.getId());
        loginResponse.setRoleName(user.getRole().getName());
        loginResponse.setUserStatus(user.getStatus());

    }
}
