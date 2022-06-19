import org.junit.Test;
import static org.junit.Assert.*;
public class ArrayDequeTest {
    
    @Test
    public void testAdd() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        d.addFront(1);
        d.printDeque();
        d.addLast(2);
        d.printDeque();
        d.addFront(3);
        d.printDeque();
        d.addLast(4);
        d.printDeque();
        d.addFront(5);
        d.printDeque();
        d.addLast(6);
        d.printDeque();
        d.addFront(7);
        d.printDeque();
        d.addLast(8);
        d.printDeque();
        d.addFront(9);
        d.printDeque();
        d.addLast(10);
        d.printDeque();
        d.addFront(11);
        d.printDeque();
        d.addLast(12);
        d.printDeque();
    }

    @Test
    public void testRemove() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int i = 1; i <= 12; i++) {
            d.addLast(i);
        }
        d.printDeque();
        assertEquals(1, d.removeFirst(), 0);
        d.printDeque();
        assertEquals(12, d.removeLast(), 0);
        d.printDeque();
        d.removeFirst();
        d.printDeque();
        d.removeLast();
        d.printDeque();
        d.removeFirst();
        d.printDeque();
        d.removeLast();
        d.printDeque();
        d.removeFirst();
        d.printDeque();
        d.removeLast();
        d.printDeque();
        d.removeFirst();
        d.printDeque();
        d.removeLast();
        d.printDeque();
        d.removeFirst();
        d.printDeque();
        d.removeLast();
        d.printDeque();
    }

    @Test
    public void testGet() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int i = 1; i <= 12; i++) {
            d.addLast(i);
        }
        d.printDeque();
        for (int i = 0; i < 12; i++) {
            assertEquals(i+1, d.get(i), 0);
        }
    }
}
