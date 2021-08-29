package ru.atom.hachaton.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ApiError {
    private final int code;
    private final String message;
    private final List<String> errors;
}
