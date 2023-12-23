package com.example.bookmanagement.dto;

import com.example.bookmanagement.converter.LowerCase;
import com.example.bookmanagement.enums.Genre;
import com.example.bookmanagement.validator.EnumValue;
import jakarta.validation.constraints.Size;

public record BookUpdate(
        @Size(min = 2, max = 100)
        String title,

        @LowerCase
        @Size(min = 2, max = 50)
        String author,

        @LowerCase
        @Size(min = 2, max = 50)
        @EnumValue(enumClass = Genre.class)
        String genre
) {
}
