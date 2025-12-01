package executor;

import job.Job;

public class ReportJobStrategy implements JobExecutionStrategy {

    @Override
    public void execute(Job job) {
        System.out.println("[ReportJob] Generating report: " + job.getName());
        System.out.println("Config: " + job.getConfig());
    }
}

