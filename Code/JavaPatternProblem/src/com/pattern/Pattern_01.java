package com.pattern;

class Day_01{
    void Problem_01(){
        for (int i=0; i<=5; i++){
            for(int j=5; j>=i; --j){
                System.out.print("  ");
            }
            for(int k=1; k<=i; ++k){
                System.out.print("* ");
            }
            for(int k1=1; k1<=i+1; ++k1){
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i=1; i<=5; i++){
            for(int j=0; j<=i; ++j){
                System.out.print("  ");
            }
            for(int k=5; k>=i; --k){
                System.out.print("* ");
            }
            for(int k1=5; k1>=i+1; --k1){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

public class Pattern_01 {
    public static void main(String[] args) {
        Day_01 D1 = new Day_01();
        D1.Problem_01();
    }
}
