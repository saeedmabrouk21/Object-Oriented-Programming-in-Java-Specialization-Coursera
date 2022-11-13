package StringsFirstAssignments;


/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    String findSimpleGene (String dna){
        int index1 = dna.indexOf("ATG");
        if(index1==-1){
            return "";
        }
        int index2 = dna.indexOf("TAA",index1+1);
        if(index2==-1){
            return "";
        }
        if((index2+2-index1)%3==2){
            return dna.substring(index1,index2+3);
        }
        return "";
    }
    void testSimpleGene(){
        String testCases[]=new String[5];
        testCases[0] = "AAATGCCCTAACTAGATTAAGAAACC";
        testCases[1] = "gjirAATGoejiojijreowitowAfdfd";
        testCases[2] = "gjiroejiojijreowitowAfdfd";
        testCases[3] = "gjiroejiATGojijreowitowTAAfdfd";
        testCases[4] = "gjiroejioATGjijreowitowTAAfdfd";
        for (int i = 0 ; i < 5 ;i++){
            System.out.println(testCases[i]+'\n'+findSimpleGene(testCases[i]));
            
        }
             
    }
}
