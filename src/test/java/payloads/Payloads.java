package payloads;


import pojos.airline.CreateAirlineRequest;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static String getCreateAirlinePayloadAsString (String id, String name, String country, String logo,
                                                  String slogan, String head_quaters, String website,
                                                    String established){
        String body = "{\n" +
                "    \"id\": "+id+",\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"country\": \""+country+"\",\n" +
                "    \"logo\": \""+logo+"\",\n" +
                "    \"slogan\": \""+slogan+"\",\n" +
                "    \"head_quaters\": \""+head_quaters+"\",\n" +
                "    \"website\": \""+website+"\",\n" +
                "    \"established\": \""+established+"\"\n" +
                "}";
        return body;
    }
    public static Map<String, Object> getCreateAirlinePayloadAsMap (String id, String name, String country, String logo,
                                                    String slogan, String head_quaters, String website,
                                                    String established){
        Map<String, Object> mapAsPayload = new HashMap();
        mapAsPayload.put("id",id);
        mapAsPayload.put("name",name);
        mapAsPayload.put("country",country);
        mapAsPayload.put("logo",logo);
        mapAsPayload.put("slogan",slogan);
        mapAsPayload.put("head_quaters",head_quaters);
        mapAsPayload.put("website",website);
        mapAsPayload.put("established",established);
        return mapAsPayload;
    }
    public static Map<String, Object> getCreateAirlinePayloadAsMap (){
        Map<String, Object> mapAsPayload = new HashMap();

        mapAsPayload.put("id", RandomDataGenerator.getRandomNumber(10));
        mapAsPayload.put("name",RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME));
        mapAsPayload.put("country",RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY));
        mapAsPayload.put("logo", RandomDataGenerator.getRandomAlphabets(25));
        mapAsPayload.put("slogan",RandomDataGenerator.getRandomAlphabets(20));
        mapAsPayload.put("head_quaters",RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME));
        mapAsPayload.put("website",RandomDataGenerator.getRandomWebsite());
        mapAsPayload.put("established",RandomDataGenerator.getRandomNumberBetween(1900, DateUtils.getCurrentYear()));
        return mapAsPayload;
    }

    public static CreateAirlineRequest getCreateAirlinePayloadFromPOJO(){
        return CreateAirlineRequest.builder()
                .id(Integer.parseInt(RandomDataGenerator.getRandomNumber(6)))
                .name(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME))
                .country(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY))
                .logo(RandomDataGenerator.getRandomAlphabets(25))
                .slogan(RandomDataGenerator.getRandomAlphabets(20))
                .head_quaters(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME))
                .website(RandomDataGenerator.getRandomWebsite())
                .established(String.valueOf(RandomDataGenerator.getRandomNumberBetween(1900, DateUtils.getCurrentYear())))
                .build();
    }
}
