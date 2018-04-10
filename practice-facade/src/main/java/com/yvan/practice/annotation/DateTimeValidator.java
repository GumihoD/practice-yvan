package com.yvan.practice.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;

/**
 * Created by yvan on 2017/5/26.
 */
public class DateTimeValidator implements ConstraintValidator<DateTimeValidation, String> {

    private String dateTimePattern;

    @Override
    public void initialize(DateTimeValidation constraintAnnotation) {
        dateTimePattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (null == value) return true;
        SimpleDateFormat sdf = new SimpleDateFormat(dateTimePattern);
        try {
            sdf.parse(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
