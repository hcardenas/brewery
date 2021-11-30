package com.hcardenas.brewery.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcardenas.brewery.bootstrap.BeerLoader;
import com.hcardenas.brewery.services.BeerService;
import com.hcardenas.brewery.web.mappers.BeerMapper;
import com.hcardenas.brewery.web.model.BeerDto;
import com.hcardenas.brewery.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
//@SpringBootTest
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @MockBean
    BeerMapper beerMapper;

    @Test
    void getBeerById() throws Exception {

        given(beerService.getById(any())).willReturn(getValidBeerDto());

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = getValidBeerDto();
         String data = objectMapper.writeValueAsString(beerDto);

        given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());


        mockMvc.perform(post("/api/v1/beer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(data))
                .andExpect(status().isCreated());

    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String data = objectMapper.writeValueAsString(beerDto);
        given(beerService.updateBeer(any(), any())).willReturn(getValidBeerDto());

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(data))
                .andExpect(status().isNoContent());

    }

    private BeerDto getValidBeerDto() {
        return BeerDto.builder()
                .beerName("My Beer")
                .price(new BigDecimal("2.99"))
                .beerStyle(BeerStyleEnum.ALE)
                .upc(BeerLoader.BEER_1_UPC)
                .build();
    }
}