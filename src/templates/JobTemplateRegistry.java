package templates;

import java.util.HashMap;
import java.util.Map;

public class JobTemplateRegistry {

    private final Map<String, JobPrototype> prototypes = new HashMap<>();

    public void register(String key, JobPrototype prototype) {
        prototypes.put(key, prototype);
    }

    public JobPrototype get(String key) {
        return prototypes.get(key);
    }
}
