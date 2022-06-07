package imdb_check24;

import imdb_check24.dto.FilmDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // server indítás random porton
public class FilmControllerIT {

    private static final String BASE_URI="/api/airports";

    @Autowired
    WebTestClient webTestClient; // tudja, melyik porton fut a server a localhoston, és oda küldi a kéréseket majd a teszt idejére

    @Test
    void testThatCreatedAirportIsListed() throws Exception {
        List<FilmDto> airportsBefore = getAllAirports();
        FilmDto newAirport = new FilmDto(5, "jdlksj" , "IGH");
        createAirport(newAirport);

        List<FilmDto>  airportsAfter = getAllAirports();

        assertThat(airportsAfter.subList(0, airportsBefore.size()))
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyElementsOf(airportsBefore);

        assertThat(airportsAfter.get(airportsAfter.size()-1))
                .usingRecursiveComparison()
                .isEqualTo(newAirport);

    }

    private void createAirport(FilmDto newAirport) {
        webTestClient
                .post()
                .uri(BASE_URI)
                .bodyValue(newAirport)
                .exchange()
                .expectStatus()
                .isOk();
    }

    private List<FilmDto> getAllAirports() {
        List<FilmDto> responseList = webTestClient
                .get()
                .uri(BASE_URI)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(FilmDto.class)
                .returnResult().getResponseBody();

        Collections.sort(responseList, (a1, a2) -> Long.compare(a1.getId(), a2.getId()));

        return responseList;
    }
}
