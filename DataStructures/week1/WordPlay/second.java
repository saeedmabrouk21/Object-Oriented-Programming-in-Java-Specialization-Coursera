
/**
 * Write a description of second here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class second {
    
    public String decrypt(String encrypt) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypt);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        System.out.println(dkey + " " + (26 - dkey));
        return cc.encrypt(encrypt, 26 - dkey);
    }
    
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
    
    
    public String decryptTwoKeys (String encrypted){
    String s1 = halfOfString(encrypted, 0);
    String s2 = halfOfString(encrypted,1);
    int key1 = getKey(s1);
    int key2 = getKey(s2);
    
    System.out.println("Key 1 " + key1 + " " + decrypt(s1));
    System.out.println("Key 2 " + key2+ " " + decrypt(s2));
      CaesarCipher cc = new CaesarCipher();
        
        String x = cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);
        System.out.println(x);
    return "saeed";
    
    
   
    
        
    }
    
    
    public void testDecrypt(){
    String saeed = "saaed";
    CaesarCipher cc = new CaesarCipher();
    String enc = cc.encrypt(saeed, 1);
    String dec = decrypt(enc);
    System.out.println(dec);
        
    }
    public void testHalfOfString(){
    System.out.println(halfOfString("saeed fares", 0));   
    System.out.println(halfOfString("saeed fares", 1));   
        
    }
    public void testDecryptTwoKeys(){
        FileResource ab = new FileResource();
        decryptTwoKeys(ab.asString());
      
    }

}
