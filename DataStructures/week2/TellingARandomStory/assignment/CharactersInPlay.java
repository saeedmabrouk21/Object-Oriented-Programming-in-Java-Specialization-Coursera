
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import edu.duke.*;
public class CharactersInPlay {
    
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<Integer> counts = new ArrayList<Integer>();
    
    public void update (String person){
        int index = names.indexOf(person);
            if(index== -1){
                names.add(person);
                counts.add(1);
                
            }else{
                counts.set(index,counts.get(index)+1);
            }
    }
    public void findAllCharacters(){
        FileResource fr = new FileResource();
        for(String x : fr.lines()){
            System.out.println(x);
            int index= x.indexOf('.');
            if(index!=-1){
                update(x.substring(0,index));
            }
            
        }
    }
    
    public void charactersWithNumParts(int num1,int num2){
        for(int i  = 0 ; i < names.size();i++){
            if(counts.get(i) >=num1 && counts.get(i)<=num2){
                System.out.println("character : " + names.get(i) + " occur "+ counts.get(i) + " times");
            }
        }
        
        
    }
    public int findIndexOfMax(){
        int j = -1 ;
        int val = -1;
        for(int i= 0 ; i<counts.size();i++){
            if(counts.get(i)>val){
                j=i;
                val=counts.get(i);
                
            }
        }
        return j;
    }
    public void tester(){
        findAllCharacters();
        System.out.println("Number of characters: " + names.size());
        for(int i  = 0 ; i < names.size();i++){
            if(counts.get(i)<=105&&counts.get(i)>=10)
                System.out.println("character : " + names.get(i) + " occur "+ counts.get(i) + " times");

        }
        int mm = findIndexOfMax();
        System.out.println(" most word: {" + names.get(mm) + "| occur "+ counts.get(mm) + " times");
        charactersWithNumParts(50,105);
    }
}
