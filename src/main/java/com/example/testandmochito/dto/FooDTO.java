package com.example.testandmochito.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class FooDTO {
    private Long id;
    private String field1;
    private String field2;
}
