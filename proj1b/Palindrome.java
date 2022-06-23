import java.util.ArrayDeque;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> ret = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            ret.addLast(word.charAt(i));
        }
        return ret;
    }
    private boolean isPalindromeHelper(Deque<Character> deq) {
        if (deq.size() <= 1) {
            return true;
        } else {
            if (deq.removeFirst() == deq.removeLast()) {
                return isPalindromeHelper(deq);
            } else {
                return false;
            }
        }
    }
    public boolean isPalindrome(String word) {
        Deque<Character> deq = wordToDeque(word);
        return isPalindromeHelper(deq);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deq = wordToDeque(word);
        while (deq.size() >= 2) {
            if (!cc.equalChars(deq.removeFirst(), deq.removeLast())) {
                return false;
            }
        }
        return true;
    }

}
