
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipher {
    public String encrypt (String input,int key){
        //second a = new second();
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        
        for(int i = 0 ; i < encrypted.length();i++){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            int lower = 0;
            if(idx != -1){
                
                char newChar = shiftedAlphabet.charAt(idx);
                if(Character.isLowerCase(currChar)){
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i,newChar);
            }
        }
        return encrypted.toString();
    }
    
    public String encryptTwoKeys (String input,int key1,int key2){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        
        for(int i = 0 ; i < encrypted.length();i++){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            int lower = 0;
            if(idx != -1){
                char newChar;
                if(i%2==0){
                    newChar = shiftedAlphabet1.charAt(idx);
                }else{
                    newChar = shiftedAlphabet2.charAt(idx);
                }
                
                if(Character.isLowerCase(currChar)){
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i,newChar);
            }
        }
        return encrypted.toString();
    }    
    
    
    
    
    public void testEncrypt (){
        //FileResource fr = new FileResource();
        //String message =fr.asString();
        //String encrypted = encrypt(message,3);
        
        //System.out.println("key is "+23+"\n"+encrypted);   
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
        //System.out.println(encrypt("First Legion",17));
    }
    public void testEncryptTwoKeys (){
           
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));

    }
}
