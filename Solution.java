
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;

public class Solution {

    public String minRemoveToMakeValid(String s) {

        Deque<Integer> stackIndexBrackets = new ArrayDeque<>();
        Set<Integer> indexBracketsToRemove = new HashSet<>();
        int size = s.length();

        for (int i = 0; i < size; i++) {

            if (s.charAt(i) == '(') {
                stackIndexBrackets.push(i);
            } else if (s.charAt(i) == ')') {

                if (!stackIndexBrackets.isEmpty()) {
                    stackIndexBrackets.pop();
                } else {
                    indexBracketsToRemove.add(i);
                }
            }
        }

        indexBracketsToRemove.addAll(stackIndexBrackets);
        StringBuilder validExpression = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (!indexBracketsToRemove.contains(i)) {
                validExpression.append(s.charAt(i));
            }
        }
        return validExpression.toString();
    }
}
