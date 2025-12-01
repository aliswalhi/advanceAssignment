package connections;

public interface ConnectionPool {

    Connection acquire() throws InterruptedException;

    void release(Connection connection);
}

