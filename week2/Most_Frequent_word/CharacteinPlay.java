
/**
 * Write a description of CharacteinPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.ArrayList;
public class CharacteinPlay {
    private ArrayList<String> names = new ArrayList();
    private ArrayList<Integer> counts = new ArrayList();
    public void update(String person){
            int index = names.indexOf(person);
            if(index == -1){
                names.add(person);
                counts.add(1);
            }
            else{
                int k = counts.get(index);
                counts.set(index,k+1);
            }
    }
    public void findAllCharacters(){
        //clear previous data
        names.clear();
        counts.clear();
        //selects a file
        FileResource fr = new FileResource();
        //opens a file and read lin by line
        int index=0;
        for(String s:fr.lines()){
            //if there is period on the line then call update
            index = s.indexOf(".");
            if(index != -1){
            String charac = s.substring(0,index);
            update(charac);
            //System.out.println(charac+"andd");
            }  
        }
    }
    public void tester(){
        findAllCharacters();
        for(int i=0;i<names.size();i++){
            System.out.println("The character "+names.get(i)+" Occured "+counts.get(i));
        }
        characterWithNumParts(70,1000);
        int n = findIndexOfMax();
        System.out.println("The most speaking character is  "+names.get(n)+" "+counts.get(n));
    }
    public void characterWithNumParts(int num1,int num2){
        for(int i=0;i<names.size();i++){
            int count = counts.get(i);
            if(count >= num1 && count <= num2){
                System.out.println("the count of "+names.get(i)+" "+counts.get(i));
            }
        }
    }
    public int findIndexOfMax(){
        int max=0;
        int counter=0;
        for(int i=0;i<names.size();i++){
            if(max<counts.get(i)){
                max = counts.get(i);
                counter = i;
            }
        }
    return counter;
    }
}
