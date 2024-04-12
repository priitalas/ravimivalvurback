package ee.valiit.ravimivalvurback.infrastructure.validation;

import ee.valiit.ravimivalvurback.domain.user.User;
import ee.valiit.ravimivalvurback.infrastructure.exception.ForbiddenException;

import java.util.Optional;

import static ee.valiit.ravimivalvurback.infrastructure.error.Error.INCORRECT_CREDENTIALS;
import static ee.valiit.ravimivalvurback.infrastructure.error.Error.USER_UNAVAILABLE;

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
}
