public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int capacity;
    private int front;   // an int indicating the position of the front element in the deque
    private int back;    // an int indicating the position of the back element in the deque

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        capacity = 8;
        front = -1;
        back = -1;
    }

    /**
     *
     * @param index: regard it as a normal array which indexes from 1 to size-1
     * return the actual index of position <index> in the circular array deque ADT
     */
    private int indexer(int index) {
        index = front + index;
        while (index < 0) {
            index += capacity;
        }
        while (index >= capacity) {
            index -= capacity;
        }
        return index;
    }

    private boolean isFull() {
        return ((back + 1 - front) % capacity == 0);
    }

    private boolean isTooLarge() {
        return (capacity > 8 && size <= capacity / 4);
    }

    private void expand() {
        if (isFull()) {
            T[] newItems = (T[]) new Object[capacity * 2];
            int p = 0;
            while (p < size) {
                int index = indexer(p);
                newItems[p] = items[index];
                p += 1;
            }
            items = newItems;
            front = 0;
            back = p - 1;
            capacity *= 2;
        }
    }

    private void shrink() {
        if (isTooLarge()) {
            T[] newItems = (T[]) new Object[capacity / 2];
            int p = 0;
            while (p < size) {
                int index = indexer(p);
                newItems[p] = items[index];
                p += 1;
            }
            items = newItems;
            front = 0;
            back = p - 1;
            capacity /= 2;
        }
    }

    public boolean isEmpty() {
        return (front == -1 && back == -1);
    }

    public void addFirst(T item) {
        expand();
        if (front == -1 && back == -1) {
            items[0] = item;
            size = 1;
            front = back = 0;
        } else {
            int p = indexer(-1);
            items[p] = item;
            front = p;
            size += 1;
        }    
    }

    public void addLast(T item) {
        expand();
        if (front == -1 && back == -1) {
            items[0] = item;
            size = 1;
            front = back = 0;
        } else {
            int p = indexer(size);
            items[p] = item;
            back = p;
            size += 1;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int p = 0;
        while (p < size) {
            int index = indexer(p);
            System.out.print(items[index] + " ");
            p += 1;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T ret = items[front];
            if (front == back) {
                front = back = -1;
            } else {
                front = indexer(1);
            }
            size -= 1;
            shrink();
            return ret;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T ret = items[back];
            if (front == back) {
                front = back = -1;
            } else {
                back = indexer(size - 2);
            }
            size -= 1;
            shrink();
            return ret;
        }
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            System.out.println("Get Error: index out of range, return null");
            return null;
        } else {
            return items[indexer(index)];
        }
    }
}
