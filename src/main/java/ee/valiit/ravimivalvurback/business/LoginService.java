package ee.valiit.ravimivalvurback.business;

import ee.valiit.ravimivalvurback.domain.user.LoginResponse;
import ee.valiit.ravimivalvurback.domain.user.User;
import ee.valiit.ravimivalvurback.domain.user.UserMapper;
import ee.valiit.ravimivalvurback.domain.user.UserRepository;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        Optional<User> optionalUser = userRepository.findAuthorizedUser(username, password);
        User user = ValidationService.getValidAuthorizedUser(optionalUser);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;
    }
}
