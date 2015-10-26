package base.service;

import base.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class UserValidator {

    private final Predicate<String> hasMinLength5 = createMinLengthPredicate(5);
    private final Predicate<String> hasMinLength8 = createMinLengthPredicate(8);
    private final Predicate<String> hasUppercase = Pattern.compile("[A-Z]").asPredicate();
    private final Predicate<String> hasLowercase = Pattern.compile("[a-z]").asPredicate();
    private final Predicate<String> hasNumber = Pattern.compile("\\d").asPredicate();
    private final Predicate<String> isAlphaNumeric = Pattern.compile("[a-zA-Z0-9]*").asPredicate();


    //TODO return specific validation errors
    public boolean isValidUser(User user) {
        return hasValidName(user.getName()) && hasValidPassword(user.getPassword());
    }

    private boolean hasValidName(String userName) {
        return hasMinLength5.test(userName) && isAlphaNumeric.test(userName);
    }

    private boolean hasValidPassword(String password) {
        List<Predicate<String>> predicates = Arrays.asList(hasMinLength8, hasUppercase, hasLowercase, hasNumber);
        return predicates.stream().allMatch(predicate -> predicate.test(password));
    }

    private Predicate<String> createMinLengthPredicate(int minLength) {
        return string -> string != null && string.length() >= minLength;
    }

}
