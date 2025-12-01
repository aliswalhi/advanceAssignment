import connections.ConnectionPool;
import connections.SimpleConnectionPool;
import executor.JobExecutor;
import executor.JobExecutorProxy;
import job.Job;
import model.User;
import templates.*;

public class MainApp {

    public static void main(String[] args) throws InterruptedException {

        User ali = new User("Ali", java.util.Arrays.asList("EMAIL", "REPORT", "DATA"));

        // ONLY USE POOL
        ConnectionPool pool = new SimpleConnectionPool(10);

        JobExecutor realExecutor = new JobExecutor();
        JobExecutorProxy executor = new JobExecutorProxy(realExecutor, pool);

        JobTemplateRegistry registry = new JobTemplateRegistry();
        registry.register("EMAIL",
                new EmailJobTemplate("Monthly Email", "format=HTML"));
        registry.register("REPORT",
                new ReportJobTemplate("SalesMonthly", "format=PDF"));
        registry.register("DATA",
                new DataJobTemplate("TransformData", "mode=FULL"));

        Job reportJob = registry.get("REPORT").cloneJob();
        reportJob.setRequestedBy(ali);

        executor.executeJob(reportJob);
    }
}
