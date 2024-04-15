package com.nabilaitnacer.adsfeeds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AttributeValueResponse {
        private List<ValueDto> attributeValues;
}
