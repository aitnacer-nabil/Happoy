package com.nabilaitnacer.dtos;


import lombok.*;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaDto implements Serializable {
    Long id;
    String imageUrl;
}