package executor;

import job.Job;

public class JobStrategyFactory {

    public JobExecutionStrategy getStrategy(String type) {
        return switch (type) {
            case "EMAIL" -> new EmailJobStrategy();
            case "DATA" -> new DataJobStrategy();
            case "REPORT" -> new ReportJobStrategy();
            default -> throw new IllegalArgumentException("Unknown job type: " + type);
        };
    }
}
