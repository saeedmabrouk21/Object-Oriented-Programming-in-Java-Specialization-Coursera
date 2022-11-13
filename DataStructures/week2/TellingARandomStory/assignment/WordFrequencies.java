
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import edu.duke.*;
public class WordFrequencies {
    private ArrayList<String> myWords ;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies (){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique (){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        
        for (String s : fr.words()) {
            int index = myWords.indexOf(s.toLowerCase());
            if(index== -1){
                myWords.add(s);
                myFreqs.add(1);
                
            }else{
                myFreqs.set(index,myFreqs.get(index)+1);
            }
        }
            
    }
    public int findIndexOfMax(){
        int j = -1 ;
        int val = -1;
        for(int i= 0 ; i<myFreqs.size();i++){
            if(myFreqs.get(i)>val){
                j=i;
                val=myFreqs.get(i);
                
            }
        }
        return j;
    }
    public void tester(){
        findUnique();
        System.out.println("Number of unique words: " + myWords.size());
        for(int i  = 0 ; i < myWords.size();i++){
       //     System.out.println("word : " + myWords.get(i) + " occur "+ myFreqs.get(i) + " times");

        }
        int mm = findIndexOfMax();
                    System.out.println(" most word: " + myWords.get(mm) + " occur "+ myFreqs.get(mm) + " times");
        
    }
}
