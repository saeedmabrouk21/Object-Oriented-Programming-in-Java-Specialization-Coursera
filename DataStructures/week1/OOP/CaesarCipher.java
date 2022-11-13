
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key){
        alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet=alphabet.substring(key)+alphabet.subSequence(0,key);
        mainKey = key;
    }
    public String encrypt (String input){
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0 ; i < sb.length();i++){
            char c = sb.charAt(i);
            boolean lower = Character.isLowerCase(c);
            int idx = alphabet.indexOf(Character.toUpperCase(c));
            if(idx!= -1){
                c=shiftedAlphabet.charAt(idx);
                
                if(lower){
                       sb.setCharAt(i,Character.toLowerCase(c));
                }else{
                    sb.setCharAt(i,c);
                }
                
            }
            
        }
        return sb.toString();
    }
    public String decrypt(String input){
        CaesarCipher b = new CaesarCipher(26-mainKey);
        return b.encrypt(input);
    }
}
