package connections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SimpleConnectionPool implements ConnectionPool {

    private final BlockingQueue<Connection> pool;

    // DEFAULT constructor (fixes the red error)
    public SimpleConnectionPool() {
        this(10); // default pool size
    }

    // custom constructor
    public SimpleConnectionPool(int maxSize) {
        this.pool = new ArrayBlockingQueue<>(maxSize);

        for (int i = 1; i <= maxSize; i++) {
            pool.offer(new Connection("Conn-" + i));
        }
    }

    @Override
    public Connection acquire() throws InterruptedException {
        return pool.take(); // waits if empty
    }

    @Override
    public void release(Connection connection) {
        if (connection != null) {
            pool.offer(connection);
        }
    }
}
