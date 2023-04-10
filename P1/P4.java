import java.util.ArrayList;
import java.util.List;

// package Practika;
// import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        System.out.println(dice2(4,2));//n в степени k
    }

    public static int dice(int side)
    {
        int result = 0;
        for (int i=1; i <= side ; i++)
        {
            for (int j=1; j <= side ; j++)
                {
                    for (int k=1; k <= side ; k++)
                        result ++ ;
                }
        }
        return result;
            
    }

    public static int recursiveCount(int depth, int maxDepth, int side)
    {
        int count = 0;
        for (int i = 1; i <= side; i++)
        {
            if(depth == maxDepth) count++;
            else count += recursiveCount( depth+1, maxDepth, side);
        }
        return count;    
    }

    public static int dice2(int k, int n)
    {
        if(k<0) return 0;
        return recursiveCount(1, k, n);
     
    }
    

}