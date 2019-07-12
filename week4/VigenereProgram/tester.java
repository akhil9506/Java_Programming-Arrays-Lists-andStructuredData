
/**
 * Write a description of tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.lang.*;
public class tester {
    /*public void testerTryKeyLength(int klength,char most){
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource();
        //System.out.println(fr.asString());
        vb.tryKeyLength(fr.asString(),klength,most);
    }*/
     public void testVigenereBreaker() {
        VigenreF vb = new VigenreF();
        vb.breakVigenere();
    }
}
