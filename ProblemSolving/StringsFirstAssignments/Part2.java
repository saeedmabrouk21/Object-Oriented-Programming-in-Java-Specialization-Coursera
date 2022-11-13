 


/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    String findSimpleGene (String dna,int startCodon,int stopCodon){
        int index1 = dna.indexOf("ATG",startCodon);
        if(index1==-1){
            return "";
        }
        int index2 = dna.indexOf("TAA",index1+1);
        if(index2==-1 || index2+2>stopCodon){
            return "";
        }
        if((index2+2-index1)%3==2){
            return dna.substring(index1,index2+3).toUpperCase();
        }
        return "";
    }
    void testSimpleGene(){
        String testCases[]=new String[5];
        testCases[0] = "gjiroejiojijreowitowTAAfdfd";
        testCases[1] = "gjirAATGoejiojijreowitowAfdfd";
        testCases[2] = "gjiroejiojijreowitowAfdfd";
        testCases[3] = "gjiroejiATGojijreowitowTAAfdfd";
        testCases[4] = "gjiroejioATGjijreowitowTAAfdfd";
        for (int i = 0 ; i < 5 ;i++){
            System.out.println(testCases[i]+'\n'+findSimpleGene(testCases[i],0,25));
            
        }
             
    }
}
