package com.codex;

// ✅ Factorial using recursion
class FactorialRecursion {
    public int factorial(int n) {
        if (n == 0 || n == 1) return 1;   // base case
        return n * factorial(n - 1);      // recursive case
    }
}

// ✅ Fibonacci using recursion
class FibonacciRecursion {
    public int fibonacci(int n) {
        if (n == 0) return 0;             // base case
        if (n == 1) return 1;             // base case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

// ✅ Print numbers from 1 to n using recursion
class PrintNumbers {
    public void printNumbers(int n) {
        if (n == 0) return;               // base case
        printNumbers(n - 1);              // recursive call
        System.out.print(n + " ");        // work after recursion
    }
}

// ✅ Sum of digits using recursion
class SumOfDigits {
    public int sumOfDigits(int n) {
        if (n == 0) return 0;             // base case
        return (n % 10) + sumOfDigits(n / 10);
    }
}

// ✅ Reverse string using recursion
class ReverseString {
    public String reverseString(String str) {
        if (str.isEmpty()) return str;    // base case
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}

// ✅ Power function (x^n) using recursion
class PowerFunction {
    public int power(int x, int n) {
        if (n == 0) return 1;             // base case
        return x * power(x, n - 1);
    }
}

// ✅ Check palindrome using recursion
class PalindromeCheck {
    public boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;    // base case
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }
}

// 🔹 Main Test Class
public class Day_15 {
    public static void main(String[] args) {
        // Factorial
        FactorialRecursion fact = new FactorialRecursion();
        System.out.println("Factorial of 5: " + fact.factorial(5));

        // Fibonacci
        FibonacciRecursion fib = new FibonacciRecursion();
        System.out.println("Fibonacci of 7: " + fib.fibonacci(7));

        // Print Numbers
        PrintNumbers pn = new PrintNumbers();
        System.out.print("Numbers from 1 to 5: ");
        pn.printNumbers(5);
        System.out.println();

        // Sum of Digits
        SumOfDigits sod = new SumOfDigits();
        System.out.println("Sum of digits of 1234: " + sod.sumOfDigits(1234));

        // Reverse String
        ReverseString rs = new ReverseString();
        System.out.println("Reverse of 'codex': " + rs.reverseString("codex"));

        // Power Function
        PowerFunction pf = new PowerFunction();
        System.out.println("2^5 = " + pf.power(2, 5));

        // Palindrome Check
        PalindromeCheck pc = new PalindromeCheck();
        String word = "madam";
        System.out.println(word + " is palindrome? " +
                pc.isPalindrome(word, 0, word.length() - 1));
    }
}
