
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private int mainkey;
    private String Shifted_alphabet;
    public CaesarCipher(int key){
        mainkey = key;
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        Shifted_alphabet = alphabet.substring(key)+alphabet.substring(0,key);
    }
    public String encrypt(String message){
        StringBuilder str = new  StringBuilder(message.length());
        for(int i=0;i<message.length();i++){
            int index = alphabet.indexOf(message.charAt(i));
            str.insert(i,Shifted_alphabet.charAt(index));
        }
        return str.toString();
    }
    public String decrypt(String message){
        //StringBuilder str = new  StringBuilder(message.length());
        CaesarCipher cc = new CaesarCipher(26-mainkey);
        String str = cc.encrypt(message);
        return str;
    }
}
