
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
     //private WebLogParser = new WebLogParser();
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile() {
         // complete method
         int i=0;
         FileResource fr =new FileResource();
         for(String s:fr.lines()){
             records.add(WebLogParser.parseEntry(s));
             i++;
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     public ArrayList<String> countUniqueIps(){
        ArrayList<String> als = new ArrayList<String>();
        for(LogEntry le :records){
            String str = le.getIpAddress();
            if(!(als.contains(str))){
                als.add(str);
            }
        }
        return als;
        }
     public void printAllHigherThanNum(int num){
         for(LogEntry le:records){
             if(num<le.getStatusCode()){
                 System.out.println(le);
                }
            }
            
        }
        public ArrayList<String> uniqueIpVisitsOnDay(String someday){
            ArrayList<String> als = new ArrayList<String>();
            
            for(LogEntry le:records){
                String str = le.getAccessTime().toString().substring(4,10);
                //System.out.println(str);
                if(someday.equals(str)&&(!als.contains(le.getIpAddress()))){
                    als.add(le.getIpAddress());
                    //System.out.println(le.getIpAddress()+"dlfnoerf");
                }
            }
            
            return als;
     }
     public int countUniqueIpsInRange(int num1,int num2){
        ArrayList<String> als = new ArrayList<String>();
        for(LogEntry le:records){
            if(num1<=le.getStatusCode()&&num2>=le.getStatusCode()&&(!als.contains(le.getIpAddress()))){
            als.add(le.getIpAddress());
            }   
    
        }
        return als.size();
        }
     public HashMap<String,Integer> countVisitsPerIP(){
         HashMap<String,Integer> map = new HashMap<String,Integer>();
         for(LogEntry le:records){
             String str = le.getIpAddress();
             if(!(map.containsKey(str))){
                 map.put(str,1);
                }
             else{
                 map.put(str,map.get(str)+1);
                }
            }
         return map;
        }
     public int mostNumberVisitsByIp(HashMap<String,Integer>mymap){
         int max=0;
         for(int curr:mymap.values()){
             if(max<curr){
                 max = curr;
             }
         }
         return max;
        }
     public ArrayList<String> ipsMostVisits(HashMap<String,Integer>map){
         ArrayList<String> ipsList = new ArrayList<String>(); 
         for(String str:map.keySet()){
             if(map.get(str)==mostNumberVisitsByIp(map)){
                 ipsList.add(str);
                }
            }
         
         return ipsList;
        }   
     public HashMap<String,ArrayList<String>> ipsForday(){
        HashMap<String,ArrayList<String>> daysmap = new HashMap<String,ArrayList<String>>();
        for(LogEntry le:records){
            String str = le.getAccessTime().toString().substring(4,10);
            if(!(daysmap.containsKey(str))){
                ArrayList<String> al = new ArrayList<String>();
                al.add(le.getIpAddress());
                daysmap.put(str,al);
            }
            else{
                ArrayList<String> al = daysmap.get(str);
                al.add(le.getIpAddress());
                daysmap.put(str,al);
            }
        }
        return daysmap;
        } 
     public String dayWithMostIPs(HashMap<String,ArrayList<String>>map){
        String most="";
        int max=0;
        for(String str:map.keySet()){
            if(max<map.get(str).size()){
                max = map.get(str).size();
                most = str;
            }
        }
        return most;
        }
     public ArrayList<String> ipsWithMostVisitsOnDay(HashMap<String,ArrayList<String>>daysmap,String day){
         ArrayList<String> dayslist = new ArrayList<String>();
         int max = 0;
         ArrayList<String> currlist = daysmap.get(day);
         HashMap<String,Integer> ipsfreq = new HashMap<String,Integer>();
         for(String le:currlist){
             //String str = le.getIpAddress();
             if(!(ipsfreq.containsKey(le))){
                 ipsfreq.put(le,1);
                }
             else{
                 ipsfreq.put(le,ipsfreq.get(le)+1);
                }
            }
            dayslist = ipsMostVisits(ipsfreq);
         return dayslist;
        }   
}
