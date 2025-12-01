package executor;

import job.Job;

public class EmailJobStrategy implements JobExecutionStrategy {

    @Override
    public void execute(Job job) {
        System.out.println("[EmailJob] Executing email job: " + job.getName());
        System.out.println("Config: " + job.getConfig());
        // simulate SQL or email sending
    }
}

