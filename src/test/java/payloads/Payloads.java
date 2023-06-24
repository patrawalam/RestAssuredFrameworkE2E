package payloads;

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
}
