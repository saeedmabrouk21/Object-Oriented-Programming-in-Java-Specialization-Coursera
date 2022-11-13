
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
    public int[] countLetters(String encrypt) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int i = 0; i < encrypt.length(); i++) {
            char ch = Character.toLowerCase(encrypt.charAt(i));
            int dex = alphabet.indexOf(ch);
            if(dex != - 1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] freqs) {
        int maxDex = 0;
        for(int i = 0; i < freqs.length; i++) {
            if(freqs[i] > freqs[maxDex]) {
                maxDex = i;
            }
        }
        return maxDex;
    }
    
    public String halfOfString (String message , int start){
        String ret = "";
        for(int i = start ; i < message.length();i=i+2){
            ret = ret + message.charAt(i);
        }
        return ret;
    
    }
    public int getKey (String s){
        int [] a =countLetters(s);
        return maxIndex(a);
        
    }
    
    public void simpleTest (){
    FileResource ab = new FileResource();
    //CaesarCipherTwo cc = new CaesarCipherTwo (21,8);
    //String enc = cc.encrypt(ab.asString());
    //String enc = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
    //System.out.println("Enc : "+enc);
    //System.out.println("dec : "+cc.decrypt(enc));
    breakCaesarCipher(ab.asString());
    }
    public void breakCaesarCipher (String input){
        String s1 = halfOfString(input, 0);
        String s2 = halfOfString(input,1);
        int maxDex1 = getKey(s1);
        int maxDex2 = getKey(s2);
        int dkey1 = maxDex1 - 4;
        if(maxDex1 < 4) {
            dkey1= 26 - (4 - maxDex1);
        }
        int dkey2 = maxDex2 - 4;
        if(maxDex2 < 4) {
            dkey2 = 26 - (4 - maxDex2);
        }
        System.out.println(dkey1 + " " +dkey2);
        CaesarCipherTwo cc = new CaesarCipherTwo (26-dkey1,26-dkey2);
        System.out.println("dec break : "+cc.encrypt(input));
    }
    
}
