 


import edu.duke.*;



/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    void ss(){
        URLResource url=new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String x : url.words()){
            int index = x.toLowerCase().indexOf("youtube.com");
            int firstDoubleQueote;
            int lastDoubleQueote;
            if(index!=-1){
                lastDoubleQueote = x.indexOf("\"",index+1);
                firstDoubleQueote = x.lastIndexOf("\"",index);
                System.out.println(x.substring(firstDoubleQueote,lastDoubleQueote+1));
            }
            
        }
    }
}
