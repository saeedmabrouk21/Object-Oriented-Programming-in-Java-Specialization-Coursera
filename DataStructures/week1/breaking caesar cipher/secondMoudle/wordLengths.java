
/**
 * Write a description of wordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class wordLengths {
    void countWordLengths(FileResource resource,int [] counts){
        for(String a : resource.words()){
            int len  = a.length();
            //System.out.println(a);
            if(len == 0)
                continue;
            if(!Character.isLetter(a.charAt(len-1))){
                len--;
            }
            if(!Character.isLetter(a.charAt(0))){
                len--;
            }
            if(len<=0)
                continue;
            if(len > counts.length){
                counts[counts.length-1]++;
            }else{
                counts[len]++;
            }
            
        }
        
        
    }
    
    void testCountWordLengths(){
        FileResource ab = new FileResource();
        int[] a = new int[31];
        countWordLengths(ab,a);
        for(int x : a ){
            System.out.println(x);
        }
        System.out.println("Max position : " + indexOfMax(a));
    }
    int indexOfMax(int [] values){
        int max = 0 ;
        for(int i = 0 ; i < values.length;i++){
            if(values[i]>values[max])
                max = i;
            
        }
        return max;   
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
