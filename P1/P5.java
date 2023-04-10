import java.util.ArrayList;
import java.util.List;

// package Practika;
// import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        for (int i = 10; i <=50; i++)
        {
            System.out.println(fib(40));
            long startTime = System.nanoTime();
            System.out.println(fibFor(40));
            long stoptTime = System.nanoTime();
            System.out.println (  stoptTime-startTime);
        }
       
    }

    public static int fib(int n)
    {
       if (n <= 1) return n;
       return fib(n-2) + fib (n-1);     
    }

    public static int fibFor(int n)
    {
       int first = 0;
       int second = 1;
       int result = 1;
       for (int i = 1; i < n; i++)
       {
        result = first + second;
        first = second;
        second = result;
       }   
       return result; 
    }

}