package co.com.automation.screenplay.web.utils.constants;

import java.util.HashMap;
import java.util.Map;


public class SharedContext {
    private SharedContext() {
    }

    private static final Map<String, Object> context = new HashMap<>();

    public static void setVariable(String key, Object value) {
        context.put(key, value);
    }

    public static Object getVariable(String key, Object defaultValue) {
        return context.getOrDefault(key, defaultValue);
    }
}


