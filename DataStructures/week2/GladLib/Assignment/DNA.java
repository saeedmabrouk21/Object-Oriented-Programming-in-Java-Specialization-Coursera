
/**
 * Write a description of DNA here.
 * 
 * @author (your name) wqe
eqwe
 */
import java.util.*; // import the HashMap class

public class DNA {
    private HashMap <String,Integer> DNACounts;
    public DNA (){
        DNACounts=new HashMap<String,Integer>();
    }
    public void buildCodonMap (int start,String dna){
         HashMap <String,Integer> codonsMap = new HashMap<String,Integer>();
         for(int i = start ; i < dna.length()-2;i=i+3){
             String w = dna.substring(i,i+3);
             if(codonsMap.keySet().contains(w)){
                 codonsMap.put(w,codonsMap.get(w)+1);
                 
             }else{    
                 codonsMap.put(w,1);             
             }
         }
         DNACounts=codonsMap;
         for(String key:codonsMap.keySet()){
            int oc = codonsMap.get(key);
           
        }
        
        
    }
    public String getMostCommonCodon(){
        int maxCount = -1;
        String codon =new String();
        for(String key:DNACounts.keySet()){
            if(DNACounts.get(key)>maxCount){
                maxCount=DNACounts.get(key);
                codon = key;
            }
        }
        return codon;
    }
    public void printCodonCounts (int start ,int end){
        for(String key:DNACounts.keySet()){
            int oc = DNACounts.get(key);
            if(oc>start &&oc<end ){
                System.out.println("Codon "+key+"found : "+oc+" times\n");
            }
        }
        
    }
    public void test(){
        String testString = "CGTTCAAGTTCAA";
        buildCodonMap(1,testString);
        printCodonCounts(0, 6);
    }
}
