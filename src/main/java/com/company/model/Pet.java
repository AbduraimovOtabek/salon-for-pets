package com.company.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Pet {
    private String pet;

    private String petName;

    private String petService;
}
