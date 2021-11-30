package com.hcardenas.brewery.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@ToString
public class BeerDto {

    @Null
    private UUID id;
    @Null
    private Integer version;
    @Null
    @JsonFormat(pattern = "yyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;
    @Null
    @JsonFormat(pattern = "yyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    private String beerName;

    @NotNull
    private BeerStyleEnum beerStyle;

    @NotNull
    private String upc;

    @NotNull
    @Positive
    @JsonFormat(shape= JsonFormat.Shape.STRING)
    private BigDecimal price;

    private Integer quantityOnHand;
}
