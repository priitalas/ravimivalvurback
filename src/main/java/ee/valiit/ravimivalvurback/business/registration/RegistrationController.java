package ee.valiit.ravimivalvurback.business.registration;

import ee.valiit.ravimivalvurback.business.registration.dto.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController

public class RegistrationController {
    private RegistrationService registrationService;

    @PostMapping("/registration")
    public void registerNewUser(@RequestBody RegistrationRequest registrationRequest) {
        registrationService.registerNewUser(registrationRequest);
    }

}
