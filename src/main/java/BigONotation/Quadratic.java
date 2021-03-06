package BigONotation;

public class Quadratic {
	public static void main(String[] args) {
		Quadratic quadratic = new Quadratic();
        QuadraticExampleType quadraticExampleType = QuadraticExampleType.CreateAllPairs;
        switch (quadraticExampleType)
        {
            case CreateAllPairs:
                int n = 5;
                quadratic.CreateAllPairs(n);
                break;
        }
	}
	
	/// Complexity: O(N^2)
    void CreateAllPairs(int n)
    {
        int x = 1;            
        while (x <= n)
        {
            int y = 1;
            while (y <= n)
            {
                System.out.printf("%d, %d \n", x, y);
                y++;
            }
            x++;
        }
    }
}
