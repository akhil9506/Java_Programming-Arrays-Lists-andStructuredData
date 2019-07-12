
/**
 * Write a description of CaserCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaserCipher {
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
    System.out.println(str.toString());
    return str.toString();
    }
    public void testCaesar(int key){
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    public String encrypttwokeys(String input,int key1,int key2){
        String s1 = encrypt(input,key1);
        String s2 = encrypt(input,key2);
        StringBuilder s= new StringBuilder(s2);
        for(int i=0;i<input.length();i +=2)
        {
            s.setCharAt(i,s1.charAt(i));
        }
        System.out.println(s.toString());
        return s.toString();
    }
}
