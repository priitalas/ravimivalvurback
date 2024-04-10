package ee.valiit.ravimivalvurback.business;

import ee.valiit.ravimivalvurback.domain.user.Status;
import ee.valiit.ravimivalvurback.domain.user.User;
import ee.valiit.ravimivalvurback.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Service
@AllArgsConstructor

public class LoginService {
    private final UserRepository userRepository;

    public void login(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(username, password, Status.DEACTIVATED);
    }

}
