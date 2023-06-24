package jsonUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JSONUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> getJSONDataAsMap(String jsonFilename) throws IOException {

        String completeJsonFilePath = System.getProperty("user.dir")+ "/src/test/resources" + jsonFilename;
        Map<String, Object> map =
                objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<Map<String, Object>>() {});
        return map;
    }

}
