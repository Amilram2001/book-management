package com.example.bookmanagement.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValueValidator implements ConstraintValidator<EnumValue, CharSequence> {
    private List<String> acceptedValues;

    @Override
    public void initialize(EnumValue annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(i -> i.name().toLowerCase())
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return acceptedValues.contains(value.toString().toLowerCase());
    }
}
