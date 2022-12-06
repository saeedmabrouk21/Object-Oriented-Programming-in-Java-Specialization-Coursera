
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Tester {
    public void testCaesarCipher(){
        FileResource f= new FileResource("titus-small.txt");
        CaesarCipher cc = new CaesarCipher(3);
        String encrypted= cc.encrypt(f.asString());
        System.out.println(encrypted);
        System.out.println(cc.decrypt(encrypted));
        
    }
    public void testCaesarCracker(){
         String fileName = "oslusiadas_key17.txt";
         FileResource f= new FileResource(fileName);
         CaesarCracker cc = new CaesarCracker('a');
         int key = cc.getKey(f.asString());
         System.out.println("key for "+fileName+" is : "+key);
         
        
    }
    public void testVigenereCipher(){
        String fileName = "titus-small.txt";
        FileResource f = new FileResource (fileName);
        VigenereCipher vc = new VigenereCipher(new int[]{17,14,12,5});
        String encrpyted = vc.encrypt(f.asString());
        String decrypted = vc.decrypt(encrpyted);
        System.out.println("Encrypted Message : "+encrpyted);
        System.out.println("Decrypted Message : "+decrypted);
    }
    
}
