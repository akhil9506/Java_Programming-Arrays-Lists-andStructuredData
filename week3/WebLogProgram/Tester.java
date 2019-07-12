
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
        // complete method
        LogAnalyzer lr = new LogAnalyzer();
        lr.readFile();
        lr.printAll();
    }
    public void testUniqueIp(){
        LogAnalyzer lr = new LogAnalyzer();
        lr.readFile();
        System.out.println("the unique ips are"+lr.countUniqueIps().size());
              
    }
    public void testernum(int num){
        LogAnalyzer lr = new LogAnalyzer();
        lr.readFile();
        lr.printAllHigherThanNum(num);
    }
    public void testUniqueIPVisits(String someday){
        LogAnalyzer lr = new LogAnalyzer();
        lr.readFile();
        ArrayList<String> al = lr.uniqueIpVisitsOnDay(someday);
        for(String s:al){
            System.out.println(s);
        }
        System.out.println(al.size());
    }
    public void testcountuniqueIpinrange(int num1,int num2){
        LogAnalyzer lr = new LogAnalyzer();
        lr.readFile();
        System.out.println(lr.countUniqueIpsInRange(num1,num2));
    }
    public void testercountVisistUniqueIps(){
        LogAnalyzer lr = new LogAnalyzer();
        lr.readFile();
        HashMap<String,Integer> map = lr.countVisitsPerIP();
        for(String str:map.keySet()){
            System.out.println(str+"  "+map.get(str));
        }
        System.out.println("The maximum number of visits by ip is "+lr.mostNumberVisitsByIp(map));
        ArrayList<String> al = lr.ipsMostVisits(map);
        System.out.println("The most ip visits");
        System.out.println(al);
    }
    public void testerdaysip(String someday){
        LogAnalyzer lr = new LogAnalyzer();
        lr.readFile();
         HashMap<String,ArrayList<String>> map = lr.ipsForday();
         for(String s:map.keySet()){
             System.out.println(s+map.get(s));
            }
            System.out.println("Day with most ip visits is "+lr.dayWithMostIPs(map));
            ArrayList<String>IP=  lr.ipsWithMostVisitsOnDay(map,someday);
            System.out.println(IP);
    }
}
