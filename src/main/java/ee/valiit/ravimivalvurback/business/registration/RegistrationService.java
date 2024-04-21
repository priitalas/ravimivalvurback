package ee.valiit.ravimivalvurback.business.registration;

import ee.valiit.ravimivalvurback.business.registration.dto.ContactChangeRequest;
import ee.valiit.ravimivalvurback.business.registration.dto.RegistrationRequest;
import ee.valiit.ravimivalvurback.domain.user.*;
import ee.valiit.ravimivalvurback.domain.user.contact.Contact;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactMapper;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactRepository;
import ee.valiit.ravimivalvurback.domain.user.role.Role;
import ee.valiit.ravimivalvurback.domain.user.role.RoleRepository;
import ee.valiit.ravimivalvurback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final ContactRepository contactRepository;
    private final UserMapper userMapper;
    private final ContactMapper contactMapper;
    private final RoleRepository roleRepository;

    public void registerNewUser(RegistrationRequest registrationRequest) {
        boolean userNameExists = userRepository.userNameExists(registrationRequest.getUsername());
        ValidationService.validateUserNameAvailable(userNameExists);
        Role role = roleRepository.getReferenceById(registrationRequest.getRoleId());
        User user = userMapper.toUser(registrationRequest);
        user.setRole(role);
        userRepository.save(user);

        Contact contact = contactMapper.toContact(registrationRequest);
        contact.setUser(user);
        contactRepository.save(contact);
    }

    public void changeUserContacts(ContactChangeRequest contactChangeRequest) {

    }
}
