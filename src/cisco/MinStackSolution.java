package cisco;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class MinStackSolution {

    public static class MinStack {
        // Deque is preferred over Stack for better performance and consistency
        private Deque<Integer> mainStack;
        private Deque<Integer> minStack;

        public MinStack() {
            mainStack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        /**
         * Pushes an element x onto the stack.
         */
        public void push(int x) {
            mainStack.push(x);

            // If minStack is empty or x is smaller than/equal to the current minimum,
            // push x onto the minStack as well.
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        /**
         * Removes the element on the top of the stack.
         */
        public void pop() {
            if (mainStack.isEmpty()) {
                return;
            }

            int removedElement = mainStack.pop();

            // If the popped element is the current minimum, remove it from minStack too
            if (removedElement == minStack.peek()) {
                minStack.pop();
            }
        }

        /**
         * Gets the top element of the stack without removing it.
         */
        public int top() {
            if (mainStack.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return mainStack.peek();
        }

        /**
         * Retrieves the minimum element in the stack in O(1) time.
         */
        public int getMin() {
            if (minStack.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        // Sample execution logic mimicking the prompt's input schema
        Scanner scanner = new Scanner(System.in);

        // Read number of operations if reading from console input stream
        // For demonstration, we hardcode the example from the user prompt
        int n = 10;
        String[] operations = {
                "push 2", "push 0", "push 3", "push 0",
                "getMin", "pop", "getMin", "pop", "top", "getMin"
        };

        MinStack minStackObj = new MinStack();
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String opLine = operations[i];
            String[] parts = opLine.split(" ");
            String command = parts[0];

            switch (command) {
                case "push":
                    int val = Integer.parseInt(parts[1]);
                    minStackObj.push(val);
                    break;
                case "pop":
                    minStackObj.pop();
                    break;
                case "top":
                    output.add(minStackObj.top());
                    break;
                case "getMin":
                    output.add(minStackObj.getMin());
                    break;
            }
        }

        // Print final aggregated output list
        System.out.println("Output: " + output); // Expected: [0, 0, 0, 0]
        scanner.close();
    }
}
