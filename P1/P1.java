import java.util.ArrayList;
import java.util.List;

// package Practika;
// import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        System.out.println("сумма всех чисел "+ sum(100) + '\n');

        System.out.println("квадратичная сложность "+ simpleDidgis(10) + '\n');
    }

    public static int sum(int n)
    {
        int result = 0;
        for (int i=1; i <=n ; i++)
            result += i ;
        return result;
    }

    public static List<Integer> simpleDidgis(int maxDigit)
    {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < maxDigit; i++)
        {
            boolean isSimple = true;
            for (int j = 2; j < i; j++)
            {
                if (i % j == 0)
                {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) result.add(i);
        }
        return result;
    }

    // boolean[] primes;
    // public Eratosfen(int n) {
    //     primes=new boolean[n+1];
    // }
    // public void fillSieve() {
    //     Arrays.fill(primes, true);
    //     primes[0] = false;
    //     primes[1] = false;
    //     for (int i = 2; i < primes.length; ++i) {
    //         if (primes[i]) {
    //             for (int j = 2; i * j < primes.length; ++j) {
    //                 primes[i * j] = false;
    //             }
    //         }
    //     }
    // }

}