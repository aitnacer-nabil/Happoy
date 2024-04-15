package com.nabilaitnacer.specificationsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ValueDto {
    private String value;
    private String attributeName;
}
