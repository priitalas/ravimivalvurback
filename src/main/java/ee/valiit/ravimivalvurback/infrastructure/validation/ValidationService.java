package ee.valiit.ravimivalvurback.infrastructure.validation;

import ee.valiit.ravimivalvurback.domain.user.User;
import ee.valiit.ravimivalvurback.infrastructure.exception.ForbiddenException;

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
}
