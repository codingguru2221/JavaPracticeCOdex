package com.codex;

import java.util.*;

public class Day_19 {

    // Function to check for balanced parentheses
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            // If opening bracket, push into stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If closing bracket, check top of stack
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // No matching opening
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        // If stack is empty, all brackets matched
        return stack.isEmpty();
    }

    // Helper function to check matching pair
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String input = sc.nextLine();

        if (isBalanced(input)) {
            System.out.println("✅ Balanced Parentheses");
        } else {
            System.out.println("❌ Not Balanced");
        }

        sc.close();
    }
}
