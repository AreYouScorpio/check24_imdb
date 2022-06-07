package imdb_check24.service;

import imdb_check24.service.FilmConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SpecialDiscountService implements DiscountService{



    @Autowired
    FilmConfigProperties config;

    @Override
    public int getDiscountPercent(int totalPrice) {
        return totalPrice>config.getDiscount().getSpecial().getLimit()
                ? config.getDiscount().getSpecial().getPercent()
                : config.getDiscount().getDef().getPercent();

    }

}
