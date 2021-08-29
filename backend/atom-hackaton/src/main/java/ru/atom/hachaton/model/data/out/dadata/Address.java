package ru.atom.hachaton.model.data.out.dadata;

import lombok.Data;

@Data
public class Address {
    private String value;
    private String unrestrictedValue;
    private AddressData data;
}
