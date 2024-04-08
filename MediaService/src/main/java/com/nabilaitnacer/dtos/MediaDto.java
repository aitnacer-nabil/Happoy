package com.nabilaitnacer.dtos;


import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaDto implements Serializable {
    Long id;
    String imageUrl;
}