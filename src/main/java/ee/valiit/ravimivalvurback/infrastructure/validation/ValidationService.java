package ee.valiit.ravimivalvurback.infrastructure.validation;

import ee.valiit.ravimivalvurback.domain.user.User;
import ee.valiit.ravimivalvurback.domain.user.doctor.DoctorPatient;
import ee.valiit.ravimivalvurback.infrastructure.exception.ForbiddenException;

import java.util.List;
import java.util.Optional;

import static ee.valiit.ravimivalvurback.infrastructure.error.Error.*;

public class ValidationService {
    public static User getValidAuthorizedUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new ForbiddenException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

    public static void validateUserNameAvailable(boolean userNameExists) {
        if (userNameExists) {
            throw new ForbiddenException(USER_UNAVAILABLE.getMessage(), USER_UNAVAILABLE.getErrorCode());
        }
    }
    public static void validateMedicineNameAvailable(boolean medicineAlreadyExists) {
        if (medicineAlreadyExists) {
            throw new ForbiddenException(MEDICINE_UNAVAILABLE.getMessage(), MEDICINE_UNAVAILABLE.getErrorCode());
        }
    }

    public static void validateUnitNameAvailable(boolean unitExists){
        if(unitExists){
            throw new ForbiddenException(UNIT_UNAVAILABLE.getMessage(),UNIT_UNAVAILABLE.getErrorCode());
        }
    }

    public static void validateDoctorHasPatients(List<DoctorPatient> doctorPatients){
        if(doctorPatients.isEmpty()){
            throw new ForbiddenException(NO_PATIENTS_FOUND.getMessage(), NO_PATIENTS_FOUND.getErrorCode());
        }
    }
}
