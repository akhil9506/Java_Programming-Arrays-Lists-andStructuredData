
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
import java.io.*;
public class WordsInFiles {
    private HashMap<String,ArrayList<String>> map;
    public WordsInFiles(){
        map = new HashMap<String,ArrayList<String>>();
    }
    private void addWordsFromFile(File f){
        String str = f.getName();
        FileResource fr = new FileResource(f);
        for(String s:fr.words()){
            ArrayList<String> al = new ArrayList<String>();
            /*if(map.containsKey(s)&&str.equals(map.get(s))){
                System.out.println("akhil");
            }*/
            if(map.containsKey(s)){
                if(!(map.get(s).contains(str)))
                map.get(s).add(str);
                //System.out.println("aaaa");
                //System.out.println(str+" "+s);
            }
            
            else{
                //System.out.println("akhil");
                //System.out.println(str+" "+s);
                al.add(str);
                map.put(s,al);
            }
        }
    }
    public void buildWordFileMap(){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    public int maxNumber(){
        int max=0;
        String str = "";
        ArrayList<String> al;
        for(String s:map.keySet()){
            //System.out.println(map.get(s).size());
            if(max<map.get(s).size()){
                max = map.get(s).size();
                str = s;
            }
            //System.out.println
        }
        return max;
    }
    public ArrayList<String> wordsInNumfiles(int num){
        ArrayList<String> wordsList = new ArrayList<String>();
        for(String s:map.keySet()){
            if(num == map.get(s).size()){
                wordsList.add(s);
            }
        }
        return wordsList;
    }
    public void printList(String s){
        ArrayList<String> fileList = map.get(s);
        System.out.println(s+"  appears in "+map.get(s).size());
        for(int i=0;i<map.get(s).size();i++){
            System.out.println(map.get(s).get(i));
        }
        System.out.println("");
    }
    public void tester(){
        buildWordFileMap();
        int max = maxNumber();
        System.out.println(max);
        ArrayList<String> list = wordsInNumfiles(max);
        System.out.println("size is "+list.size());
        for(int i=0;i<list.size();i++){
            printList(list.get(i));
        }
    }    
    public int numberOfWords(int n){
        int sum=0;
        for(String s:map.keySet()){
            if(n==map.get(s).size()){
                System.out.println(map.get(s).size());
                sum +=1;
            }
        }
        return sum;
    }
}
