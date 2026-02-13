package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    private static final String PHONE_PATTERN = "^[+]?[(]?[0-9]{1,4}[)]?[-\\s\\.]?[(]?[0-9]{1,4}[)]?[-\\s\\.]?[0-9]{1,9}$";
    
    private Pattern pattern;

    @Override
    public void initialize(ValidPhone constraintAnnotation) {
        pattern = Pattern.compile(PHONE_PATTERN);
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        if (phone == null || phone.isEmpty()) {
            return true; // Use @NotNull or @NotEmpty for null/empty validation
        }
        return pattern.matcher(phone).matches();
    }
}
