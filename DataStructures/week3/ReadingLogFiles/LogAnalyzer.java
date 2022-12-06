
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records  = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource f = new FileResource(filename);
         for(String a : f.lines()){
             records.add(WebLogParser.parseEntry(a));
         }
     }
     
     public int countUniqueIPs(){

         ArrayList<String>uniqueIPs = new ArrayList<String>();
         
         for(LogEntry le:records){
             String ipAddr = le.getIpAddress();
             if(!uniqueIPs.contains(ipAddr)){
                 uniqueIPs.add(ipAddr);
                 
             }
             
         }
         
         
         return uniqueIPs.size();
         
     }
        
     public void printAllHigherThanNum (int num){
         for(LogEntry le:records){
             int statusCode = le.getStatusCode();
             if(statusCode > num){
                 System.out.println(le);
                 
             }
             
         }
         
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String>uniqueIPs= new ArrayList<String>();
         for(LogEntry le:records){
             String data = le.getAccessTime().toString();
             //System.out.println(someday+"@@@@@"+data+"$$$$");
             if(someday.equals(data.substring(4,10)) && !uniqueIPs.contains(le.getIpAddress())){
                 uniqueIPs.add(le.getIpAddress());
                 
             }
             
         }
         System.out.println("size of unique ips" +uniqueIPs.size());
         return uniqueIPs;
     }
     
     public int countUniqueIPsInRange (int low,int high){

         ArrayList<String>uniqueIPs= new ArrayList<String>();
         for(LogEntry le:records){
             int statusCode = le.getStatusCode();
             if(statusCode >= low && statusCode <=high && !uniqueIPs.contains(le.getIpAddress())){

                 uniqueIPs.add(le.getIpAddress());
             }
             
         }
         return uniqueIPs.size();
         
     }
     
     public HashMap<String,Integer>countVisitsPerIP(){
         HashMap<String,Integer>counts = new HashMap<String,Integer>();
         for(LogEntry le:records){
             String ip= le.getIpAddress();
             if(!counts.containsKey(ip)){
                 counts.put(ip,1);
             }else{
                 counts.put(ip,counts.get(ip)+1);
             }
             
         }
         
         
         return counts;
         
         
     }
     
     public int mostNumberVisitsByIP(HashMap<String,Integer> counts){
         int maxVisits = 0;
         for(String ab : counts.keySet()){
              if(counts.get(ab)>maxVisits){
                  maxVisits = counts.get(ab);
              }
         }
         return maxVisits;
         
     }
     
     public ArrayList<String> iPsMostVisits (HashMap<String,Integer> hash){
         
         int maxVisits = mostNumberVisitsByIP(hash);
         ArrayList<String> aa = new ArrayList<String>();
         for(String str:hash.keySet()){
             if(hash.get(str)==maxVisits){
                 aa.add(str);
             }
             
         }
         return aa;
     }
     
     public HashMap<String,ArrayList<String>> ipsForDays(){
         HashMap<String,ArrayList<String>> ret= new HashMap<String,ArrayList<String>>();
         
         //ArrayList<String>uniqueIPs= new ArrayList<String>();
         for(LogEntry le:records){
             String data = le.getAccessTime().toString();
             //System.out.println(someday+"@@@@@"+data+"$$$$");
             if(ret.keySet().contains(data.substring(4,10))){
                 ret.get(data.substring(4,10)).add((le.getIpAddress()));
                 
             }else{

                 
                 ArrayList<String> aa = new ArrayList<String>();
                 aa.add(le.getIpAddress());
                 ret.put(data.substring(4,10),aa);
                }
             
         }
         return ret;
     }
     public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> hash){
         String mostIp = iPsMostVisits(countVisitsPerIP()).get(0);
         String day="";
         for(String x:hash.keySet()){
             if(hash.get(x).contains(mostIp)){
                 day = x;
                 break;
             }
             
         }
         return day;
         
     }
    
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
