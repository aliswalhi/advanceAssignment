package executor;

import job.Job;

public class DataJobStrategy implements JobExecutionStrategy {

    @Override
    public void execute(Job job) {
        System.out.println("[DataJob] Processing data job: " + job.getName());
        System.out.println("Config: " + job.getConfig());
    }
}
