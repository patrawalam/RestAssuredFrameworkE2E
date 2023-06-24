package common;

import jsonUtils.JSONUtils;

import java.io.IOException;
import java.util.Map;

public class TestBase {

    public static Map<String, Object> dataFromJson;

    static {
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        try {
            dataFromJson = JSONUtils.getJSONDataAsMap("/env/" + env + "/target_env_config.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
