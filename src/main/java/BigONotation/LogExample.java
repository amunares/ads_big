package BigONotation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.lang.time.StopWatch;



public class LogExample {

	public static void main(String[] args) {
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		System.out.println("Starting...");
        LogExample logExample = new LogExample();
        System.out.println("Step 1: Reading Log Items...");
        int lineCount = logExample.ReadAllLogs();
        System.out.printf("{0:n0} Log Items Read \n", lineCount);
        System.out.println("Step 2: Counting Unique IPs...");
        int ipCount = logExample.CountUniqueIPs();
        System.out.println("Number of unique IPs: " + ipCount);
        
		System.out.printf("Time elapsed: %.2f seconds ", (stopWatch.getTime() / 1000.0));

	}
	
	 int ReadAllLogs()
     {
		 LogReader logReader = new LogReader();
         int linesSeen = 0;
         for(LogLine line : logReader)
         {
             String ip = line.GetIP();
             linesSeen++;
         }
         return linesSeen;
     }
	 
	 int CountUniqueIPs()
     {
		 LogReader logReader = new LogReader();
         DataStructureType dataStructureType = DataStructureType.List;
         Collection<String> ipsSeen = null;
         switch (dataStructureType)
         {
             case List: ipsSeen = new ArrayList<String>(); break;
             case HashSet: ipsSeen = new HashSet<String>(); break;
             default: ipsSeen = new ArrayList<String>(); break;
         }

         for(LogLine logLine : logReader)
         {
             String ip = logLine.GetIP();
             if (!ipsSeen.contains(ip))
             {
                 ipsSeen.add(ip);
             }
         } 
         return ipsSeen.size();
     }

}
