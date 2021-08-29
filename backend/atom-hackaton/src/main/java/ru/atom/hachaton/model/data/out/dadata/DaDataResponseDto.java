package ru.atom.hachaton.model.data.out.dadata;

import lombok.Data;

@Data
public class DaDataResponseDto {
    private Suggestion[] suggestions;
}
