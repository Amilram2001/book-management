package com.example.bookmanagement.entity;

import com.example.bookmanagement.converter.LowerCase;
import com.example.bookmanagement.enums.Genre;
import com.example.bookmanagement.validator.EnumValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @NotBlank
    @Size(min = 2, max = 100)
    String title;

    @NotBlank
    @LowerCase
    @Size(min = 2, max = 50)
    String author;

    @NotBlank
    @LowerCase
    @Size(min = 2, max = 50)
    @EnumValue(enumClass = Genre.class)
    String genre;
}