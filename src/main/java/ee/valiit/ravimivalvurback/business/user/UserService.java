package ee.valiit.ravimivalvurback.business.user;

import ee.valiit.ravimivalvurback.business.user.dto.ContactInfo;
import ee.valiit.ravimivalvurback.domain.user.contact.Contact;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactMapper;
import ee.valiit.ravimivalvurback.domain.user.contact.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public void changeUserContact(ContactInfo contactInfo) {
        Contact contact = contactRepository.findContactBy(contactInfo.getUserId());
        contactMapper.updateContact(contactInfo, contact);
        contactRepository.save(contact);
    }
    public ContactInfo getContactInfo(Integer userId) {
        Contact contact = contactRepository.findContactBy(userId);
        return contactMapper.toContactInfo(contact);
    }
}

