package imdb_check24.service;

public class NonUniqueIataException extends RuntimeException{

    public NonUniqueIataException(String iata) {
        super("Existing IATA: "+ iata);
    }
}
