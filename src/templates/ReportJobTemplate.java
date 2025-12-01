package templates;

import job.Job;

public class ReportJobTemplate implements JobPrototype {

    private final String type = "REPORT";
    private final String name;
    private final String config;

    public ReportJobTemplate(String name, String config) {
        this.name = name;
        this.config = config;
    }

    @Override
    public Job cloneJob() {
        String id = type + "-" + System.currentTimeMillis();
        return new Job(id, type, name, config);
    }
}

