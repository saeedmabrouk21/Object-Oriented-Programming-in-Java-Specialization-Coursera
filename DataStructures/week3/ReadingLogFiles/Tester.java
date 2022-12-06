
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer a = new LogAnalyzer();
        a.readFile("short-test_log");
        a.printAll();
    }
    
    public void testUniqueIP(){
        LogAnalyzer a = new LogAnalyzer();
        a.readFile("we2_log");
        System.out.println("Number of unique addressess is "+a.countUniqueIPs());
        
    }
    public void testPrintAllHigherThanNum (){
        LogAnalyzer a = new LogAnalyzer();
        a.readFile("short-test_log - Copy");
        int x = 400;
        System.out.println("Number of logs have status code higher than "  + x + "\n");
        a.printAllHigherThanNum(x);
        
    }
    
    public void testUniqueIPVisitsOnDay (){
        LogAnalyzer a = new LogAnalyzer();
        a.readFile("we2_log");
        ArrayList <String> ab = a.uniqueIPVisitsOnDay("Sep 27");
        //ArrayList <String> aa = a.uniqueIPVisitsOnDay("Sep 30");
        System.out.println("size of ab " +ab.size());
        for(String x : ab ){
            //System.out.println(x);
            
        }
    }
    
    public void testCountUniqueIPsInRange (){
        LogAnalyzer a = new LogAnalyzer();
        a.readFile("we2_log");
        System.out.println("countUniqueIPsInRange(200,299) " + a.countUniqueIPsInRange(200,299)); 
    }
    
    public void testMostNumberVisitsByIP(){
        LogAnalyzer a = new LogAnalyzer();
        a.readFile("we2_log");
        System.out.println("most number visits "+a.mostNumberVisitsByIP(a.countVisitsPerIP()));
    }
    public void testIPsMostVisits (){
        LogAnalyzer a = new LogAnalyzer();
        a.readFile("we2_log");
        System.out.println("most number visits "+a.iPsMostVisits(a.countVisitsPerIP()));
    }
    public void testIPsForDays(){
        LogAnalyzer a = new LogAnalyzer();
        a.readFile("weblog3-short_log");
        System.out.println("ip for days "+a.ipsForDays());
        
    }
    public void testDayWithMostIPVisits(){
        LogAnalyzer a = new LogAnalyzer();
        a.readFile("we2_log");
        System.out.println("ip for days "+a.dayWithMostIPVisits(a.ipsForDays()));
    }
    
}
