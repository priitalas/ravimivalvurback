package ee.valiit.ravimivalvurback.business.login;

import ee.valiit.ravimivalvurback.business.login.dto.LoginResponse;
import ee.valiit.ravimivalvurback.domain.user.*;
import ee.valiit.ravimivalvurback.domain.user.role.Role;
import ee.valiit.ravimivalvurback.domain.user.role.RoleRepository;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        Optional<User> optionalUser = userRepository.findAuthorizedUser(username, password);
        User user = ValidationService.getValidAuthorizedUser(optionalUser);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        Role role = roleRepository.findUserRole(user.getRole().getId(), user.getRole().getName());
        loginResponse.setRoleName(role.getName());
        return loginResponse;
    }
}
