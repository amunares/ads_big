package BigONotation;

import org.apache.commons.lang.time.StopWatch;


public class Exponential {

	public static void main(String[] args) {
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Exponential exponential = new Exponential();
		ExponentialExampleType exponentialExampleType = ExponentialExampleType.Fibonacci;
		
		switch (exponentialExampleType) 
		{
			case Fibonacci:
				int n = 50; //8 40 80
				for (int i = 1; i <= n; i++)
                {
					try {
					 long fibonacci = exponential.Fibonacci(i);
					 System.out.printf("fibonacci %d = %d  \n", i, fibonacci);
					 
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
                }
				break;
		}
		System.out.printf("Time elapsed: %.2f seconds ", (stopWatch.getTime() / 1000.0));
	}
	
	 /// Complexity: O(2^N)
    int Fibonacci(long n) throws Exception
    {
        if (n < 0)
        {
            throw new Exception("n can not be less than zero");
        }
        if (n <= 2)
        {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

}
