package imdb_check24.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "film")
@Component
public class FilmConfigProperties {

    private Discount discount = new Discount();

    public Discount getDiscount() {
        return discount;
    }


    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public static class Discount {
        private Default def = new Default();
        private Special special = new Special();

        public Default getDef() {
            return def;
        }

        public void setDef(Default def) {
            this.def = def;
        }

        public Special getSpecial() {
            return special;
        }

        public void setSpecial(Special special) {
            this.special = special;
        }
    }

    public static class Default {
        private int percent;

        public int getPercent() {
            return percent;
        }

        public void setPercent(int percent) {
            this.percent = percent;
        }
    }

    public static class Special {
        private int percent;
        private int limit;

        public int getPercent() {
            return percent;
        }

        public void setPercent(int percent) {
            this.percent = percent;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }


}
