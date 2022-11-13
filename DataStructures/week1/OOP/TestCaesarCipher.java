
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipher {
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
    
    
    public void simpleTests (){
        FileResource ab = new FileResource();
        CaesarCipher cc = new CaesarCipher(15);
        String enc = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println("encrypted : " + enc);
        System.out.println("decrypted : " + cc.decrypt(enc));
        breakCaesarCipher(enc);
    }
    public void breakCaesarCipher (String input){
        int maxDex = maxIndex(countLetters(input));
        int dkey = maxDex - 4;
        if(maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        CaesarCipher cc = new CaesarCipher(dkey);
        
        System.out.println("cc.decrypt(input);  " +cc.decrypt(input)); 
    }
}
