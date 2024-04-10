package ee.valiit.ravimivalvurback.infrastructure.validation;
import ee.valiit.ravimivalvurback.infrastructure.exception.ForbiddenException;
import ee.valiit.ravimivalvurback.domain.user.User;
import ee.valiit.ravimivalvurback.infrastructure.exception.DataNotFoundException;
import ee.valiit.ravimivalvurback.infrastructure.exception.ForbiddenException;

import java.util.List;
import java.util.Optional;

import static ee.valiit.ravimivalvurback.infrastructure.error.Error.*;

import java.util.Optional;

public class ValidationService {
    public static User getValidExistingUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new ForbiddenException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();

    }
}
