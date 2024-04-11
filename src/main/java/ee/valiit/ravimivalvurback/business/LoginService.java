package ee.valiit.ravimivalvurback.business;

import ee.valiit.ravimivalvurback.domain.user.LoginResponse;
import ee.valiit.ravimivalvurback.domain.user.User;
import ee.valiit.ravimivalvurback.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {

    private UserRepository userRepository;

    public void login(String username, String password) {
        Optional<User> user = userRepository.findAuthorizedUser(username, password);

    }
}
