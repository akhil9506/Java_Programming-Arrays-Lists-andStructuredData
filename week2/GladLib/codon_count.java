
/**
 * Write a description of codon_count here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class codon_count {
    private HashMap<String,Integer> dnaMap;
    public codon_count(){
        dnaMap = new HashMap<String,Integer>();
    }
    public void buildCodonMap(int start,String dna){
        dnaMap.clear();
        int curr_index;
        String str;
        curr_index = start;
        while(curr_index+2<dna.length()){
            //start from start index and while loop
            //extract every 3 chars
            str = dna.substring(curr_index,curr_index+3);
            //check weather that part is present in dnamap
            //if present then increase count
            if(dnaMap.containsKey(str)){
                int k = dnaMap.get(str);
                dnaMap.put(str,k+1);
            }
            //else add it in hashmap
            else{
                dnaMap.put(str,1);
            }           
            //update curr_index
            curr_index += 3;
        }
    }
    public void printCodons(int start,int end){
        for(String s:dnaMap.keySet()){
            int n = dnaMap.get(s);
            if(n>start&&n<end)
            System.out.println("total count "+s+"  "+dnaMap.get(s));
        }
    }
    public void tester(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        for(int i=0;i<3;i++){
            buildCodonMap(i,dna);
            System.out.println("The total number of unique codons are "+dnaMap.size());
            int max=0;
            String str="";
            for(String s:dnaMap.keySet()){
                if(max<dnaMap.get(s)){
                    max = dnaMap.get(s);
                    str =s ;                } 
            }
            System.out.println("The most commom codon occuring is "+str+" And its occurence is "+max);
            System.out.println("Counts of codon between 1 to 5 are:");
            printCodons(6,8);
        }
    }
}
