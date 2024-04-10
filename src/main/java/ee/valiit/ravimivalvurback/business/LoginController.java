package ee.valiit.ravimivalvurback.business;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @GetMapping ("/login")
    public void login(@RequestParam String username, @RequestParam String password) {

    }


}
