package BigONotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.time.StopWatch;



public class Lineal {
	
	long[] fibonacciCache = null;
	
	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Lineal lineal = new Lineal();
		LinealExampleType linealExampleType = LinealExampleType.Fibonacci;
		int nFibonacciCache = 80; //8 40 80
		lineal.fibonacciCache = new long[nFibonacciCache + 1];
		switch (linealExampleType)
        {
            case Loop:
                int n = 50;
                lineal.Loop(n);
                break;
            case ContainsNeedle:	           	
                List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 18, 29, 1, 0, 75, 79));
                int needle = 76;
                boolean found = lineal.ContainsNeedle(needle, numberList);
                System.out.printf("Number %d found? %b \n", needle, found);
                break;
            case Factorial:
                int nFactorial = 10;
                long factorial = lineal.Factorial(nFactorial);
                System.out.printf("Factorial of %d equal to %d \n", nFactorial, factorial);
                break;
            case Fibonacci:
                int nFibonacci = 80; //8 40 80
                for (int i = 1; i <= nFibonacci; i++)
                {
                	try {
                		long fibonacci = lineal.Fibonacci(i);
                        System.out.printf("fibonacci %d = %d \n", i, fibonacci);
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
                }
                break;
            case FibonacciCache:
                for (int i = 1; i <= nFibonacciCache; i++)
                {
                	try {
                		long fibonacci = lineal.FibonacciCache(i);
                        System.out.printf("fibonacci %d = %d \n", i, fibonacci);
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
                    
                }
                break;
        }
		System.out.printf("Time elapsed: %.2f seconds ", (stopWatch.getTime() / 1000.0));
	}
	
	/// Complexity: O(N)
	void Loop(long n)
    {
        long counter = 1;
        while (counter <= n)
        {
            System.out.println(counter);
            counter++;
        }
    }
	
	/// Complexity: O(N)
    boolean ContainsNeedle(int needle, List<Integer> numberList)
    {
    	
        for (Integer item : numberList)
        {
            if (item == needle)
            {
                return true;
            }
        }
        return false;
    }
    
    /// Complexity: O(N)
    long Factorial(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        return n * Factorial(n - 1);
    }
    
    /// Complexity: O(N)
    long Fibonacci(long n) throws Exception
    {
        if (n < 0)
        {
            throw new Exception("n can not be less than zero");
        }
        if (n <= 2)
        {
            return 1;
        }
        long fibonacci = 0;
        long previous = 1;
        long penultimate = 0;
        for (int i = 1; i <= n; i++)
        {
            penultimate = fibonacci;
            fibonacci = previous + fibonacci;
            previous = penultimate;
        }
        return fibonacci;
    }
    
  /// Complexity: O(N)
    public long FibonacciCache(long n) throws Exception
    {
        if (n < 0)
        {
            throw new Exception("n can not be less than zero");
        }
        if (n <= 2)
        {
            fibonacciCache[(int) n] = 1;
        }
        if (fibonacciCache[(int) n] == 0)
        {
            fibonacciCache[(int) n] = FibonacciCache(n - 1) + FibonacciCache(n - 2);
        }
        return fibonacciCache[(int) n];
    }
}
