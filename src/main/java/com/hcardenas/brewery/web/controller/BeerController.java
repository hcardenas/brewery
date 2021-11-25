package com.hcardenas.brewery.web.controller;


import com.hcardenas.brewery.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{beerID}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("/{beerID}") UUID beerId) {
        // TODO: impl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto) {

        //TODO: impl

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{beerID}")
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable("/{beerID}") UUID beerId, @RequestBody BeerDto beerDto) {
        // TODO: impl

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
