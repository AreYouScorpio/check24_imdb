package imdb_check24.service;


import imdb_check24.service.FilmConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DefaultDiscountService implements DiscountService {

    @Autowired
    imdb_check24.service.FilmConfigProperties config;

    @Override
    public int getDiscountPercent(int totalPrice) {
        return config.getDiscount().getDef().getPercent();
    }

}
