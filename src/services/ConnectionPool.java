package services;

import java.util.concurrent.ArrayBlockingQueue;

public class ConnectionPool {

    private ArrayBlockingQueue<Object> pool;

    public ConnectionPool(int size) {
        pool = new ArrayBlockingQueue<>(size);
        for (int i = 0; i < size; i++) pool.add(new Object());
    }

    public Object acquire() {
        try { return pool.take(); }
        catch (Exception e) { return null; }
    }

    public void release(Object o) {
        if (o != null) pool.offer(o);
    }
}
