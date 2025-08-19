//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i <= 5; i++) {
//            1st star pattern
            for (int j = 5; j >= i; --j) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; ++k) {
                System.out.print("* ");
                
            }
            System.out.println();
        }
    }
}