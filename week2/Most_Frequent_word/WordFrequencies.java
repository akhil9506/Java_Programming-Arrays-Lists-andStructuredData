
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.ArrayList;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies(){
        myWords = new ArrayList();
        myFreqs = new ArrayList();
    }
    void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String s:fr.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
        }
    }
    public void tester(){
        findUnique();
        int num;
        System.out.println("number of unique words are "+myWords.size());
        for(int i=0;i<myWords.size();i++){
            System.out.println(myWords.get(i)+" freq is "+myFreqs.get(i));
        }
        int k = findIndexOfMax();
        int i = myFreqs.get(k);
        //System.out.println(i);
        System.out.println("The word with max index is "+i+" and word is  "+myWords.get(k)+" and number of unique words are "+myWords.size());
    }
    public int findIndexOfMax(){
        int max=0;
        int counter=0;
        for(int i=0;i<myWords.size();i++){
            if(max<myFreqs.get(i)){
                max = myFreqs.get(i);
                counter = i;
            }
        }
    return counter;
    }
}
