public class LinkedListDeque<T> {
    /* subclass Node */
    private class Node {
        public T item;
        public Node next;
        public Node prev;
        public Node(T i, Node n, Node p) {
            this.item = i;
            this.next = n;
            this.prev = p;
        }
    }
    /* record size so size() can be computed at constant time
     * sentinel's next point to the first Node, and prev points to the last Node */
    private int size;
    private Node sentinel;
    public LinkedListDeque() {
        this.size = 0;
        this.sentinel = new Node(null, null, null);
    }
    public LinkedListDeque(T i) {
        this.size = 1;
        Node n = new Node(i, null, null);
        this.sentinel = new Node(null, n, n);
    }

    public void addFirst(T item) {
        Node firstOld = sentinel.next;
        Node firstNew = new Node(item, firstOld, null);
        if (firstOld == null) {
            sentinel.next = firstNew;
            sentinel.prev = firstNew;
        } else {
            sentinel.next = firstNew;
            firstOld.prev = firstNew;
        }
        size += 1;
    }
    public void addLast(T item) {
        Node lastOld = sentinel.prev;
        Node lastNew = new Node(item, null, lastOld);
        if (lastOld == null) {
            sentinel.prev = lastNew;
            sentinel.next = lastNew;
        } else {
            sentinel.prev = lastNew;
            lastOld.next = lastNew;
        }
        size += 1;
    }

    /**
     * only trust next and prev pointers
     */
    public boolean isEmpty() {
        return (this.sentinel.next == null && this.sentinel.prev == null);
    }

    /**
     * size is recorded by deque
     */
    public int size() {
        return this.size;
    }

    public void printDeque() {
        Node p = this.sentinel;
        while(p.next != null) {
            p = p.next;
            System.out.print(p.item + " ");
        }
        System.out.println("");
    }

    /**
     * removes the first Node and return its value, return null if the deque is empty
     */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else if (this.size() == 1) {
            T ret = sentinel.next.item;
            sentinel.next = null;
            sentinel.prev = null;
            size = 0;
            return ret;
        } else {
            Node second = sentinel.next.next;
            T ret = sentinel.next.item;
            sentinel.next = second;
            second.prev = null;
            size -= 1;
            return ret;
        }
    }

    /**
     * removes the last Node and return its value, return null if the deque is empty
     */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else if (this.size() == 1) {
            T ret = sentinel.prev.item;
            sentinel.next = null;
            sentinel.prev = null;
            size = 0;
            return ret;
        } else {
            Node second = sentinel.prev.prev;
            T ret = sentinel.prev.item;
            sentinel.prev = second;
            second.next = null;
            size -= 1;
            return ret;
        }
    }

    /**
     * non-destructively return the item at position index,
     * begins 0 at the first node (not include sentinel)
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            Node p = sentinel;
            while (index >= 0) {
                index -= 1;
                p = p.next;
            }
            return p.item;
        }
    }

    private T getHelper(int index, Node p) {
        if (p == null) {
            return null;
        } else if (index == 0) {
            return p.item;
        } else {
            return getHelper(index-1, p.next);
        }
    }
    public T getRecursive(int index) {
        return getHelper(index, sentinel.next);
    }
}
