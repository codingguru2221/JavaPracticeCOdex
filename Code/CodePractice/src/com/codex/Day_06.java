package com.codex;

// ✅ Custom Exception (Checked Exception)
class AgeNotValidException extends Exception {
    public AgeNotValidException(String message) {
        super(message);
    }
}

public class Day_06 {

    // Method that throws Custom Checked Exception
    static void checkAge(int age) throws AgeNotValidException {
        if (age < 18) {
            throw new AgeNotValidException("❌ Age must be 18 or above to vote.");
        } else {
            System.out.println("✅ Eligible to vote!");
        }
    }

    // Method to demonstrate Checked Exception (throws keyword)
    static void fileOperation() throws java.io.IOException {
        java.io.FileReader fr = new java.io.FileReader("test.txt"); // File may not exist
        fr.close();
    }

    public static void main(String[] args) {
        // ✅ Example 1: Arithmetic Exception
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e);
        } finally {
            System.out.println("Finally block executed after ArithmeticException.\n");
        }

        // ✅ Example 2: NullPointerException
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e);
        }

        // ✅ Example 3: ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e);
        }

        // ✅ Example 4: NumberFormatException
        try {
            int num = Integer.parseInt("ABC");
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e);
        }

        // ✅ Example 5: Checked Exception using throws (FileNotFoundException)
        try {
            fileOperation();
        } catch (java.io.IOException e) {
            System.out.println("Caught IOException (Checked): " + e);
        }

        // ✅ Example 6: Custom Exception
        try {
            checkAge(15);
        } catch (AgeNotValidException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }

        // ✅ Example 7: Multiple Catch Blocks
        try {
            int[] arr = new int[3];
            arr[3] = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException inside multiple catch: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException inside multiple catch: " + e);
        }

        // ✅ Example 8: General Exception Catch
        try {
            Object obj = "Codex";
            Integer num = (Integer) obj; // ClassCastException
        } catch (Exception e) {
            System.out.println("Caught General Exception (ClassCastException): " + e);
        }

        System.out.println("\n👉 Program completed successfully with all exceptions handled!");
    }
}
