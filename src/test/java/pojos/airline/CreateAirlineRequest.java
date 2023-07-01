package pojos.airline;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import net.datafaker.idnumbers.PeselNumber;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

import java.util.Arrays;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAirlineRequest {
    private int id = Integer.parseInt(RandomDataGenerator.getRandomNumber(6));
    private String name = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
    private String country = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY);
    private String logo = RandomDataGenerator.getRandomAlphabets(25);
    private String slogan = RandomDataGenerator.getRandomAlphabets(20);
    private String head_quaters = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME);
    private String website = RandomDataGenerator.getRandomWebsite();
    private String established = String.valueOf(RandomDataGenerator.getRandomNumberBetween(1900, DateUtils.getCurrentYear()));
}
