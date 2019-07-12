
/**
 * Write a description of Wordlengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Wordlengths {
    public void countWordlengths(FileResource fr,int counts[]){
        for(String s:fr.words()){
            int k=0;
            if(s.length()>1){
            if(!(Character.isLetter(s.charAt(s.length()-1)))){k++;}
            if(!(Character.isLetter(s.charAt(0)))){k++;}
            if((s.length()-k)>counts.length-1){counts[counts.length-1]+=1;}
            else
            counts[s.length()-k] += 1;
            System.out.println("The word is "+s+" length is "+(s.length()-k));
            }
            else{
                if(Character.isLetter(s.charAt(0))){counts[1]+=1;}
                else{counts[0]+=1;}
            }
        }
        for(int i =0;i<counts.length;i++){
            System.out.println("The numer of words of length "+i+" is "+counts[i]);
        }
    }
    public void testCountWordLengths(){
        int [] counts = new int[31];
        FileResource fr = new FileResource();
        countWordlengths(fr,counts);
        System.out.println("The most common wordlength occuring is "+index_of_Max(counts));
    }
    public int index_of_Max(int values[]){
        int max=0;
        for(int i=0;i<values.length;i++){
            if(values[max] < values[i]){
                max = i;
            }
        }
        return max;
    }
}
