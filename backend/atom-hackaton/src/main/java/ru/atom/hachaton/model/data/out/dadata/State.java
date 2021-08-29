package ru.atom.hachaton.model.data.out.dadata;

import lombok.Data;

@Data
public class State {
    private String status;
    private String code;
    private String actualityDate;
    private String registrationDate;
    private String liquidationDate;
}
