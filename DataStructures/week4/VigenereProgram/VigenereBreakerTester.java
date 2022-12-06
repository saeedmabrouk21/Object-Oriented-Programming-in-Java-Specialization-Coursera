
/**
 * Write a description of VigenereBreakerTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class VigenereBreakerTester {
    private VigenereBreaker vb = new VigenereBreaker();
    public void testSliceString(){
        System.out.println(vb.sliceString("abcdefghijklm", 0, 3));
        System.out.println(vb.sliceString("abcdefghijklm", 3, 5));
        
    }
    public void testTryKeyLength(){
        String fileName = "secretmessage1.txt";
        FileResource f = new FileResource(fileName);
        int[] arr = vb.tryKeyLength(f.asString(),4,'e');
        for (int element: arr) {
            System.out.println(element);
        }
    }
}
