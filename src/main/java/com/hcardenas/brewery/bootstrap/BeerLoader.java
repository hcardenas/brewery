package com.hcardenas.brewery.bootstrap;


import com.hcardenas.brewery.domain.Beer;
import com.hcardenas.brewery.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Helmut Beer")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(BEER_1_UPC)
                    .minOnHand(12)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Aleksey Beer")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .upc(BEER_2_UPC)
                    .minOnHand(12)
                    .price(new BigDecimal("11.99"))
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("Cardenas Beer")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .upc(BEER_3_UPC)
                    .minOnHand(12)
                    .price(new BigDecimal("15.99"))
                    .build());
        }
    }
}
