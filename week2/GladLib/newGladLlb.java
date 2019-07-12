
/**
 * Write a description of newGladLlb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class newGladLlb {
    /*
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList;*/
    private Random myRandom;
    private ArrayList<String> trackList;
    private HashMap<String,ArrayList<String>> mymap;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public newGladLlb(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public newGladLlb(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        /*
        adjectiveList= readIt(source+"/adjective.txt"); 
        nounList = readIt(source+"/noun.txt");
        colorList = readIt(source+"/color.txt");
        countryList = readIt(source+"/country.txt");
        nameList = readIt(source+"/name.txt");      
        animalList = readIt(source+"/animal.txt");
        timeList = readIt(source+"/timeframe.txt");
        fruitList = readIt(source+"/fruit.txt");
        verbList = readIt(source+"/verb.txt");*/
        trackList = new ArrayList();
        mymap = new HashMap<String,ArrayList<String>>();
        String[] labels = {"country","adjective","noun","animal","name","color","fruit","verb","timeframe"};
        for(String s:labels){
            ArrayList<String> list = readIt(source+"/"+s+".txt");
            mymap.put(s,list);
        }
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        /*if (label.equals("country")) {
            return randomFrom(countryList);
        }
        if (label.equals("color")){
            return randomFrom(colorList);
        }
        if (label.equals("noun")){
            return randomFrom(nounList);
        }
        if (label.equals("name")){
            return randomFrom(nameList);
        }
        if (label.equals("adjective")){
            return randomFrom(adjectiveList);
        }
        if (label.equals("animal")){
            return randomFrom(animalList);
        }
        if (label.equals("timeframe")){
            return randomFrom(timeList);
        }*/
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        /*
        if(label.equals("fruit")){
            return randomFrom(fruitList);
        }
        if(label.equals("verb")){
            return randomFrom(verbList);
        }*/
        return randomFrom(mymap.get(label));
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        String ans = prefix+sub+suffix;
        //trackList.add(prefix+sub+suffix);
        //System.out.println(prefix+" 111 "+suffix);
        while(trackList.contains(ans)){
            sub = getSubstitute(w.substring(first+1,last));
            ans = prefix+sub+suffix;
            //System.out.println("the changed word is "+ans);
        }
        trackList.add(ans);
        return ans;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        trackList.clear();
        System.out.println("\n");
                String story = fromTemplate("datalong/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("Total number of words considered is " +totalwordsconsidered());
    }       
    public int totalWordsInMap(){
            int sum=0;
            for(String s:mymap.keySet()){
                sum = sum +mymap.get(s).size();
            }
            System.out.println(sum+"=total number of words");
            return sum;
    }
    public int totalwordsconsidered(){
        int i=0;
        i = trackList.size();
        return i;
    }
}

