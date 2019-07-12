import java.util.*;
import edu.duke.*;
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder stb = new StringBuilder();
        for(int i=whichSlice;i<message.length();i+=totalSlices){
            stb.append(message.charAt(i));
        }
        return stb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        for(int i=0;i<klength;i++){
            CaesarCracker cs = new CaesarCracker(mostCommon);
            //System.out.println(sliceString(encrypted,i,klength));
            key[i] = cs.getKey(sliceString(encrypted,i,klength));
            //System.out.println(cs.decrypt(sliceString(encrypted,i,klength)));
            //System.out.println(key[i]);
        }
        return key;
    }

    public void breakVigenere (char most) {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String message = fr.asString();
        FileResource fd = new FileResource();
        VigenereBreaker vb = new VigenereBreaker();
        HashSet hs = readDictionary(fd);
        int keylength = breakForLanguage(message,hs,'e');
        int[] key =vb.tryKeyLength(message,keylength,most);
        VigenereCipher vg = new VigenereCipher(key);
        String decrypted = vg.decrypt(message);
        System.out.println(decrypted);
        //return decrypted;
    }
    public HashSet<String> readDictionary(FileResource fr){
        //codehere
        HashSet<String> hs = new HashSet();
        for(String s:fr.lines()){
            hs.add(s.toLowerCase());
        }
        return hs;
    }
    public int countWords(String message,HashSet<String> hs){
        String[] strarray = message.split("\\W"); 
        int num=0;
        for(int i=0;i<strarray.length;i++){
            if(hs.contains(strarray[i].toLowerCase())){
                num++;
            }
        }
        return num;
    }
    public int breakForLanguage(String encrypted,HashSet<String>hs,char most){
        int max_key = 1;
        int max=0;
        for(int i=1;i<100;i++){
            String decrypted;
            int[] arr = tryKeyLength(encrypted,i,most);
            VigenereCipher vg = new VigenereCipher(arr);
            decrypted = vg.decrypt(encrypted);
            int k = countWords(decrypted,hs);
            if(k>max){
                max = k;
                max_key = i;
            }
            if(i==38){
                //System.out.println("At 38 is "+max);
            }
        }
        //System.out.println("The max key igdffd gfsg f dfggggggg gfdgd  "+max_key+" " +max);
        return max;
    }
    public char mostCommonCharIn(HashSet<String>hs){
        //codehere
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(String s:hs){
            for(char c:s.toCharArray()){
                if(hm.containsKey(c)){
                    hm.put(c,hm.get(c)+1);
                }
                else{
                    hm.put(c,1);
                }
            }
        }
        int max_char=0;
        char ch = ' ';
        for(char c:hm.keySet()){
            if(max_char<hm.get(c)){
                max_char = hm.get(c);
                ch = c;
            }
            
        }
        return ch;
    }
    public void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>>languages){
        //codehere
        int max=0;
        for(String s:languages.keySet()){
            int i = breakForLanguage(encrypted,languages.get(s),mostCommomChar(languages.get(s)));
            if(max<i){
                max = i;
            }
        }
    }
}
