package ee.valiit.ravimivalvurback.business;


import ee.valiit.ravimivalvurback.business.dto.LoginResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @GetMapping("/login")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        loginService.login(username, password);
        LoginResponse loginResponse = new LoginResponse();
        return loginResponse;

    }

}
