package imdb_check24.service;

import imdb_check24.service.DefaultDiscountService;
import imdb_check24.service.DiscountService;
import imdb_check24.service.SpecialDiscountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!prod")
public class DiscountConfiguration {


    @Bean
    public DiscountService discountService() {
        return new DefaultDiscountService();
    }


}
