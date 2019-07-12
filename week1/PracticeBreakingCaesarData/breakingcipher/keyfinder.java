
/**
 * Write a description of keyfinder here.
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class keyfinder {
    public String encrypt(String input,int key){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String al = alphabet.substring(key)+alphabet.substring(0,key);
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String a =  alpha.substring(key)+alpha.substring(0,key);
        StringBuilder str = new StringBuilder(input);
        for(int i=0;i<input.length();i++){
            if(Character.isUpperCase(str.charAt(i))){
                int index = alphabet.indexOf(str.charAt(i));
                if(index != -1 )
                str.setCharAt(i,al.charAt(index));
            }
            else{
                int index = alpha.indexOf(str.charAt(i));
                if(index != -1 )
                str.setCharAt(i,a.charAt(index));
            
            }
        }
        //System.out.println(str.toString());
        return str.toString();
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
    public String decrypt(String encrypted){
        StringBuilder s1 = new StringBuilder(encrypted.length());
        StringBuilder s2 = new StringBuilder(encrypted.length());
        System.out.println(encrypted+encrypted.length());
        for(int i=0,c=0;i<encrypted.length();i+=2){
            if(i>=encrypted.length()){break;}
            //System.out.println("Hello"+i+encrypted.charAt(i));
            s1.insert(c++,encrypted.charAt(i));
        }
        for(int i=1,c=0;i<encrypted.length();i+=2){
            if(i>=encrypted.length()){break;}
            s2.insert(c++,encrypted.charAt(i));
        }
        int [] freqs = countLetters(s1.toString());
        int maxDex = maxIndex(freqs);
        //System.out.println(freqs[maxDex]);
        //System.out.println("The max dex is "+maxDex);
        int dkey = maxDex -4;
        if(maxDex <4){
            dkey  = 22 +maxDex;
        }
        String s1dup = encrypt(s1.toString(),26-dkey);
        int [] freqs2 = countLetters(s2.toString());
        int maxDex2 = maxIndex(freqs2);
        //System.out.println(freqs2[maxDex2]);
        //System.out.println("The max dex is "+maxDex2);
        int dkey2 = maxDex2 - 4;
        if(maxDex<4){
            dkey = maxDex-4;
        }
        String s2dup = encrypt(s2.toString(),26-dkey2);
        StringBuilder f = new StringBuilder(encrypted.length());
        System.out.println("Dkey1 is "+dkey+"Dkey2 is "+dkey2);
        for(int i=0,a=0,b=0;i<encrypted.length();i++){
            //System.out.println(f.charAt(i)+i);
            if(i%2==0){
                f.insert(i,s1dup.charAt(a++));
            }
            else{
                //System.out.println("Hello"+i+s2dup.charAt(i));
                f.insert(i,s2dup.charAt(b++));
            }
            //System.out.println(f.charAt(i)+" index "+i);
        }
        System.out.println(f.toString());
        return f.toString();
    }
    public void testDecrypt(){
        FileResource fr = new FileResource();
        System.out.println(decrypt(fr.asString()));
    }
    public String halfOfString(String message,int start){
        StringBuilder s = new StringBuilder(message.length());
        for(int i=start,c=0;i<message.length();i+=2){
            s.insert(c++,message.charAt(i));
            }
            return s.toString();
    }
    public char getKey(String s){
        int[] freqs = countLetters(s);
        int maxDex =  maxIndex(freqs); 
        String str = "abcdefghijklmnopqrstuvwxyz";
        return str.charAt(maxDex);
    }
}