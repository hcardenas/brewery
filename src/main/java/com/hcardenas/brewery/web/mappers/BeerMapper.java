package com.hcardenas.brewery.web.mappers;

import com.hcardenas.brewery.domain.Beer;
import com.hcardenas.brewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beer);
}
