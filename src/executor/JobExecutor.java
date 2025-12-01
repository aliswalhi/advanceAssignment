package executor;

import job.Job;

public class JobExecutor {

    private final JobStrategyFactory factory = new JobStrategyFactory();

    public void executeJob(Job job) {
        JobExecutionStrategy strategy = factory.getStrategy(job.getType());
        strategy.execute(job);
    }
}
