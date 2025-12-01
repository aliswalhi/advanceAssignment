package executor;

import job.Job;

public interface JobExecutionStrategy {
    void execute(Job job);
}
