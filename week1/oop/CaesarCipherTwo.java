
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipherTwo {
    private int Mainkey1;
    private int Mainkey2;
    private String alpha = "abcdefghijklmnopqrstuvwxyz";
    private String shiftedalpha1;
    private String shiftedalpha2;
    public CaesarCipherTwo(int key1,int key2){
        Mainkey1 = key1;
        Mainkey2 = key2;
        shiftedalpha1 = alpha.substring(key1)+alpha.substring(0,key1);
        shiftedalpha2 = alpha.substring(key2)+alpha.substring(0,key2);
    }
    public int[] countLetters(String s){
        String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String b = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            int index = a.indexOf(s.charAt(i));
            int index2 = b.indexOf(s.charAt(i));
            if(index != -1){
            count[index] += 1;
            //System.out.println(s.charAt(i)+" index "+i+" coutn "+count[index]);
             }
            if(index2!=-1){
                count[index2]+=1;
            //System.out.println(s.charAt(i)+" index "+i+" coutn "+count[index2]);
              }
            }
        return count;
    }
    public int maxIndex(int[] values){
        int max=0;
        for(int i=0;i<values.length;i++){
            //System.out.println("the index "+i+" "+max+" "+values[i]);
            if(values[max] <= values[i]){
                max = i;
            }
        }
        return max;
    }
    public String halfOfString(String message,int start){
        StringBuilder s = new StringBuilder(message.length());
        for(int i=start,c=0;i<message.length();i+=2){
            s.insert(c++,message.charAt(i));
            }
            return s.toString();
    }
    public void simpleTests(){
        FileResource fr = new FileResource();
        CaesarCipherTwo cc2 = new CaesarCipherTwo(17,3);
        
    }
    public String encrypt1(String message){
        StringBuilder str = new  StringBuilder(message.length());
        for(int i=0;i<message.length();i++){
            int index = alpha.indexOf(message.charAt(i));
            str.insert(i,shiftedalpha1.charAt(index));
        }
        return str.toString();
    }
    public String encrypt2(String message){
        StringBuilder str = new  StringBuilder(message.length());
        for(int i=0;i<message.length();i++){
            int index = alpha.indexOf(message.charAt(i));
            str.insert(i,shiftedalpha2.charAt(index));
        }
        return str.toString();
    }
    
}
