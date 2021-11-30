package com.hcardenas.brewery.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcardenas.brewery.web.model.BeerDto;
import com.hcardenas.brewery.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = getValidBeerDto();
         String data = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(data))
                .andExpect(status().isCreated());

    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String data = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(data))
                .andExpect(status().isCreated());

    }

    private BeerDto getValidBeerDto() {
        return BeerDto.builder()
                .beerName("My Beer")
                .price(new BigDecimal("2.99"))
                .beerStyle(BeerStyleEnum.ALE)
                .upc(123123123123L)
                .build();
    }
}