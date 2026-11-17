package cisco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateValidAngleBracketSequences {

    /**
     * Generates all valid nested sequences of n pairs of '<' and '>'.
     * <p>
     * Time Complexity: O(4^n / n^(3/2)) - Proportional to the n-th Catalan number.
     * Space Complexity: O(n) - Maximum depth of the recursion stack is 2 * n.
     *
     * @param n The number of pairs of angle brackets.
     * @return A list of all valid sequence combinations.
     */
    public static List<String> generateSequences(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        // Initiate the recursive backtracking process
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    /**
     * Backtracking helper method to build well-formed bracket paths.
     */
    private static void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base case: If the current string reaches the target length (2 * n), it is fully formed.
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Choice 1: Place an opening bracket '<' if we haven't reached the limit 'max' yet.
        if (open < max) {
            current.append('<');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Backtrack: Undo the placement
        }

        // Choice 2: Place a closing bracket '>' if there are unmatched opening brackets available.
        if (close < open) {
            current.append('>');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack: Undo the placement
        }
    }

    public static void main(String[] args) {
        // Test Case 1: n = 1
        System.out.println("n = 1 Results: " + generateSequences(1));
        // Expected Output: [<>]

        // Test Case 2: n = 2
        System.out.println("n = 2 Results: " + generateSequences(2));
        // Expected Output: [<<>>, <><>]

        // Test Case 3: n = 3
        System.out.println("n = 3 Results: " + generateSequences(3));
        // Expected Output: [<<<>>>, <<><>>, <<>><>, <><<>>, <><><>]

        // Continuous terminal execution environment simulation
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a custom value for n: ");
        if (scanner.hasNextInt()) {
            int customN = scanner.nextInt();
            List<String> variations = generateSequences(customN);
            System.out.println("Total Generated Sequences (" + variations.size() + "):");
            for (String sequence : variations) {
                System.out.println(sequence);
            }
        }
        scanner.close();
    }
}
