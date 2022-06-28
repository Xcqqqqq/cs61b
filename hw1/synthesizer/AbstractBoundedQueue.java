package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T>{
    protected int fillCount;
    protected int capacity;
    public abstract T peek();
    public abstract T dequeue();
    public abstract void enqueue(T x);
    public int capacity() {
        return capacity;
    }
    public int fillCount() {
        return fillCount;
    }
    /* inherited from BoundedQueue
    public boolean isEmpty();
    public boolean isFull();
    void Enqueue(T x);
    T Dequeue();
    T Peek();
    */
}
