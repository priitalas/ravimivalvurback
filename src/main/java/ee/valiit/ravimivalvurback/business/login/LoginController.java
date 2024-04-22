package ee.valiit.ravimivalvurback.business.login;


import ee.valiit.ravimivalvurback.business.login.dto.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Logib kasutaja rakendusse sisse")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        return loginService.login(username, password);
    }
}
