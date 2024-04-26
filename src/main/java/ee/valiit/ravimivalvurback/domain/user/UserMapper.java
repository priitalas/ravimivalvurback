package ee.valiit.ravimivalvurback.domain.user;

import ee.valiit.ravimivalvurback.business.login.dto.LoginResponse;
import ee.valiit.ravimivalvurback.business.registration.dto.RegistrationRequest;
import ee.valiit.ravimivalvurback.domain.Status;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "status", target = "userStatus")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(constant = Status.ACTIVE, target = "status")
    User toUser (RegistrationRequest registrationRequest);

    @Mapping(source = "status", target = "status")
    User updateDoctorPatientRelation (User user);

}