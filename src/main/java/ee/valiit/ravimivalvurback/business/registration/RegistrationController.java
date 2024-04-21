package ee.valiit.ravimivalvurback.business.registration;

import ee.valiit.ravimivalvurback.business.registration.dto.ContactChangeRequest;
import ee.valiit.ravimivalvurback.business.registration.dto.RegistrationRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController

public class RegistrationController {
    private RegistrationService registrationService;

    @PostMapping("/registration")
    @Operation(summary = "Registreerib andmebaasi uue kasutaja")
    public void registerNewUser(@RequestBody RegistrationRequest registrationRequest) {
        registrationService.registerNewUser(registrationRequest);
    }

    @PutMapping("/registration")
    @Operation(summary = "Muudab olemasoleva kasutaja andmeid")
    public void changeUserContacts(@RequestBody ContactChangeRequest contactChangeRequest) {
        registrationService.changeUserContacts(contactChangeRequest);
    }

}
