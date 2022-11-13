 

import edu.duke.URLResource;

public class Part4 {
    

    
    public Part4(){
        
    }
    
    public String getYoutubeLink(){
        URLResource urlResource = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        String source = urlResource.asString();
        String lowerCaseSource = source.toLowerCase();
        int startIndex = lowerCaseSource.indexOf("youtube.com");
        if(startIndex == -1){
            //no link
            return "";
        }else{
          System.out.println(source);
          }
        
        startIndex = lowerCaseSource.lastIndexOf("\"", startIndex)+1;
        int endIndex = lowerCaseSource.indexOf("\"", startIndex);
        
//      System.out.println(startIndex + " " + endIndex);
        
        return source.substring(startIndex, endIndex);
    }
    
    public void testing(){
        System.out.println("SASA");
        System.out.println(getYoutubeLink());
    }
}