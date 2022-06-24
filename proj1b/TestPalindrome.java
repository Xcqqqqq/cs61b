import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertFalse(palindrome.isPalindrome("AbcBa"));
        assertFalse(palindrome.isPalindrome("w%w&w"));
        // tests for generalized isPalindrome method
        CharacterComparator cc1 = new OffByOne();
        assertTrue(palindrome.isPalindrome("", cc1));
        assertTrue(palindrome.isPalindrome("a", cc1));
        assertTrue(palindrome.isPalindrome("flake", cc1));
        assertTrue(palindrome.isPalindrome("mopn", cc1));
        assertFalse(palindrome.isPalindrome("racecar", cc1));
        assertFalse(palindrome.isPalindrome("AbcBa", cc1));
        CharacterComparator cc5 = new OffByN(5);
        assertTrue(palindrome.isPalindrome("auczf", cc5));
        assertFalse(palindrome.isPalindrome("flake", cc5));
    }
}
