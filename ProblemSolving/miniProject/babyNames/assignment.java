import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class assignment {
    void totalBirths (FileResource fr){
        int totalBoysBirths = 0;
        int totalGirlsBirths = 0;
        for(CSVRecord rec:fr.getCSVParser(false)){
            if(rec.get(1).equals("M")){
                totalBoysBirths+= 1;
            }else{
                totalGirlsBirths+= 1;
            }
        }
        System.out.println(totalGirlsBirths);
        System.out.println(totalBoysBirths);

    }
    int getRank(int year,String name,String gender){
        FileResource ab = new FileResource("../us_babynames_by_year/yob"+year+".csv");
        int rank = 1 ; 
        if(gender.equals("F")){
            for(CSVRecord rec:ab.getCSVParser(false)){
                if(rec.get(1).equals("M")){
                    return -1;
                }
                if(rec.get(0).equals(name)){
                    return rank;
                }else{
                    rank++;
                }
            }   
        }else{
            
            for(CSVRecord rec:ab.getCSVParser(false)){
                if(rec.get(1).equals("F")){
                    continue;
                }
                if(rec.get(0).equals(name)){
                    return rank;
                }else{
                    rank++;
                }
            }
            return -1;
        
        
        }
        return 999;
        
    }
    String getName(int year,int rank,String gender){
        FileResource ab = new FileResource("../us_babynames_by_year/yob"+year+".csv");
        int index = 1;
        if(gender.equals("F")){
            for(CSVRecord rec:ab.getCSVParser(false)){
                if(rec.get(1).equals("M")){
                    return "NO NAME";
                }
                if(index==rank){
                    return rec.get(0);
                }else{
                    index++;
                }
            }   
        }else{
            for(CSVRecord rec:ab.getCSVParser(false)){
                if(rec.get(1).equals("F")){
                    continue;
                }
                if(index==rank){
                    return rec.get(0);
                }else{
                    index++;
                }
            }
            return "NO NAME";
        }
        return "NO NAME";
        
    }
    void whatIsNameInYear(String name,int year,int newYear,String gender){
        int rank = getRank(year,name,gender);
        String newName = getName(newYear,rank,gender);
        System.out.println(name+" born in "+year+" would be "+newName+" in "+newYear);
    }
    int yearOfHighestRank(String name,String gender){
        DirectoryResource ab = new DirectoryResource();
        int rank = -1 ;
        int finalRank = -1;
        int year =-1;
        for(File f:ab.selectedFiles()){
            int index = f.toString().indexOf("yob");
            rank = getRank(Integer.parseInt(f.toString().substring(index+3,index+7)),name,gender);
            if(rank !=-1 &&rank<finalRank || finalRank==-1){
                finalRank=rank;
                year = Integer.parseInt(f.toString().substring(index+3,index+7));
            }
        }
        return year;
    }
    double getAverageRank(String name,String gender){
        DirectoryResource ab = new DirectoryResource();
        double rank = -1 ;
        double sumRank = -1;
        int numRank=0;
        for(File f:ab.selectedFiles()){
            int index = f.toString().indexOf("yob");
            rank = getRank(Integer.parseInt(f.toString().substring(index+3,index+7)),name,gender);
            if( rank!=-1.0){
                sumRank+=rank;
                numRank++;
            }
        }
        if(numRank == -1)
            return sumRank;
        return sumRank/numRank;
    }
    
    
    
    
    
    
    
    
    
    
    
    void testTotalBirths (){
        FileResource ab = new FileResource();
        totalBirths(ab);
    }
    void testgetRank(){
        System.out.println(getRank(1971,"Frank","M"));
    }
    void testgetName(){
        System.out.println(getName(1982,450,"M"));
    }
    void testWahtIsNameInYear(){
        whatIsNameInYear("Owen",1974,2014,"M");
    }
    void testYearOfHighestRank(){
        System.out.println(yearOfHighestRank("Genevieve","F"));
        System.out.println(yearOfHighestRank("Mich","M"));
    }
    void testGetAverageRank(){
        System.out.println(getAverageRank("Robert","M"));
        //System.out.println(getAverageRank("Mason","F"));
    }
   
}
