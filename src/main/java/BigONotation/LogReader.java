package BigONotation;

import java.util.Iterator;

public class LogReader implements Iterable<LogLine> { 
	

	int counter = 0;
	
	@Override
	public Iterator<LogLine> iterator() {
		int N = 100000;
		int uniqueIPs = 90001;
		
		 while (counter < N)
         {
             counter++;
         }	
		 
		 return iterator();
	}
	
		
}
