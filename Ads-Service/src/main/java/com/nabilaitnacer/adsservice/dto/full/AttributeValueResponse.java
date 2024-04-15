package com.nabilaitnacer.adsservice.dto.full;

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
