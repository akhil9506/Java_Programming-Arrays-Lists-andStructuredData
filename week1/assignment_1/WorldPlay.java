
/**
 * Write a description of WorldPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.File;
public class WorldPlay {
    public boolean isVowel(char c){
        c = Character.toUpperCase(c);
        if(c=='A'||c=='E'||c=='I'||c=='U'||c=='O'){
        return true;
        }
        return false;
    }
    public void isVowel(){
        System.out.println("output for f"+isVowel('F'));
        System.out.println("output for a"+isVowel('o'));
    }
    public String replaceVowels(String s,char c){
    StringBuilder str = new StringBuilder(s);
    for(int i =0;i<s.length();i++){
        if(isVowel(s.charAt(i))){
            str.setCharAt(i,c);
        }
    }
    return str.toString();
    }
    public String emphasize(String phrase,char ch){
        StringBuilder str = new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
            System.out.println("fvrvprovkrg "+Character.toUpperCase(str.charAt(i))+"  "+Character.toUpperCase(ch));
            if(Character.toUpperCase(str.charAt(i))==Character.toUpperCase(ch)){
                char c = (i%2==0)?'*':'+';
                str.setCharAt(i,c);
            }
        }
        return str.toString();
    }
    
}
