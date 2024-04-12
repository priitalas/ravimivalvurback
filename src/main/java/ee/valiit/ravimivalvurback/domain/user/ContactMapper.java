package ee.valiit.ravimivalvurback.domain.user;

import ee.valiit.ravimivalvurback.business.dto.ContactInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    ContactInfo toContactInfo(Contact contact);
}

