package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(4);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.peek();
        System.out.println(arb.dequeue());  // 1
        System.out.println(arb.peek());  // 2
        System.out.println(arb.dequeue()); // 2
        System.out.println(arb.peek());  // 3
        System.out.println(arb.dequeue());  // 3
        System.out.println(arb.peek());  // 4
        System.out.println(arb.dequeue());  // 4
        System.out.println(arb.peek()); // nothing
        //arb.dequeue();  // error
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
