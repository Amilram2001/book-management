package com.example.bookmanagement.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class LowerCaseConverter extends StdConverter<String, String> {
    @Override
    public String convert(String s) {
        return s == null ? null : s.toLowerCase();
    }
}
