package executor;

import connections.Connection;
import connections.ConnectionPool;
import job.Job;

public class JobExecutorProxy {

    private final JobExecutor realExecutor;
    private final ConnectionPool pool;

    public JobExecutorProxy(JobExecutor executor, ConnectionPool pool) {
        this.realExecutor = executor;
        this.pool = pool;
    }

    public void executeJob(Job job) throws InterruptedException {

        // 1) Permission check
        if (!job.getRequestedBy().hasPermission(job.getType())) {
            throw new RuntimeException("User not allowed for this job type");
        }


        System.out.println("[Proxy] Starting job: " + job.getName());


        Connection conn = pool.acquire();
        long start = System.currentTimeMillis();

        try {

            realExecutor.executeJob(job);

        } finally {

            pool.release(conn);

            long duration = System.currentTimeMillis() - start;


            System.out.println("[Proxy] Finished job: " + job.getName());
            System.out.println("[Proxy] Execution time: " + duration + " ms");
        }
    }
}
