
/**
 * Write a description of TestCasearCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCasearCipher {
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
    public void SimpleTests(){
        FileResource fr = new FileResource();
        CaesarCipher cc = new CaesarCipher(18);
        String str = cc.encrypt(fr.asString());
        System.out.println(str);
    }
}
