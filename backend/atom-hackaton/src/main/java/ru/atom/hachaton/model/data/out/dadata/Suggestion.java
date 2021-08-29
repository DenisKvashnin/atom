package ru.atom.hachaton.model.data.out.dadata;

import lombok.Data;

@Data
public class Suggestion {
    private String value;
    private String unrestrictedValue;
    private DataDto data;
    private String founders;
    private String managers;
    private String predecessors;
    private String successors;
    private String branchType;
    private Integer branchCount;
    private String source;
    private String qc;
    private String hid;
    private String type;
    private State state;
    private Opf opf;
    private Name name;
    private String inn;
    private String ogrn;
    private String okpo;
    private String okato;
    private String oktmo;
    private String okogu;
    private String okfs;
    private String okveds;
    private String finance;
    private Address address;
}
