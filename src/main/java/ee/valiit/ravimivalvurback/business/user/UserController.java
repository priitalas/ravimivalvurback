package ee.valiit.ravimivalvurback.business.user;

import ee.valiit.ravimivalvurback.business.registration.dto.ContactInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class UserController {
private final UserService userService;
    @GetMapping("/user")
    @Operation(summary = "Leiab olemasoleva kasutaja andmed")
    public ContactInfo getContact(@RequestParam Integer userId) {
        return userService.getContactInfo(userId);
    }

    @PutMapping("/user")
    @Operation(summary = "Muudab olemasoleva kasutaja andmeid")
    public void changeUserContact(@RequestBody ContactInfo contactInfo) {
        userService.changeUserContact(contactInfo);
    }
}
