import static org.junit.Assert.*;

import edu.princeton.cs.algs4.In;
import org.junit.Test;
// tests if your addFirst, addLast, removeFirst and removeLast methods behave the same as solution
public class TestArrayDequeGold {
    private int methodSelector;  // 0 -- addFirst, 1 -- addLast, 2 -- removeFirst, 3 -- removeLast
    private Integer yourNum;
    private Integer solNum;
    private int numToInsert;
    private int TESTCASES = 100;
    private int MINNUM = 1;
    private int MAXNUM = 10000;
    private String msg = "";

    @Test
    public void testArrayDeque() {
        StudentArrayDeque<Integer> yourArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solArray = new ArrayDequeSolution<>();
        // do insertion
        for (int i = 0; i < TESTCASES; i++) {
            methodSelector = StdRandom.uniform(4);
            numToInsert = StdRandom.uniform(MINNUM,MAXNUM);
            switch (methodSelector) {
                case 0:
                    yourArray.addFirst(numToInsert);
                    solArray.addFirst(numToInsert);
                    msg = msg + "addFirst(" + numToInsert + ")\n";
                    break;
                case 1:
                    yourArray.addLast(numToInsert);
                    solArray.addLast(numToInsert);
                    msg = msg + "addLast(" + numToInsert + ")\n";
                    break;
                case 2:
                    yourNum = yourArray.removeFirst();
                    solNum = solArray.removeFirst();
                    msg += "removeFirst()\n";
                    break;
                case 3:
                    yourNum = yourArray.removeLast();
                    solNum = solArray.removeLast();
                    msg += "removeLast()\n";
                    break;
                default:   // do nothing
            }
            assertEquals(msg, solNum, yourNum);
        }
    }
}
