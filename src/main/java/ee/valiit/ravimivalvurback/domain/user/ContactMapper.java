package ee.valiit.ravimivalvurback.domain.user;

import ee.valiit.ravimivalvurback.business.registration.dto.RegistrationRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactMapper {
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "", target = "")
    Contact toContact(RegistrationRequest registrationRequest);
}

