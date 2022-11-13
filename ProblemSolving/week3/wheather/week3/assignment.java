
/**
 * Write a description of assignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class assignment {
    CSVRecord compare (CSVRecord r1,CSVRecord r2,String col){
        if(r1==null){
            return r2;
        }
        if(r2==null){
            return r1;
        }
        if(Double.parseDouble(r1.get(col))>=Double.parseDouble(r2.get(col))){
            return r2;
        }
        return r1;
    }
    CSVRecord lowestRecord (CSVParser parser,String col,String not){
        CSVRecord lowest = null;
        for(CSVRecord r : parser){
            //System.out.println(r.get(col));
            if(r.get(col).equals(not)){
                //System.out.println("ddd");
                continue;
            }
            //System.out.println("SAS  "+r.get(col)); 
            lowest = compare(lowest,r,col);
        }
        return lowest;
        
    }
   
    void testColdentHourInFile(){
        FileResource ab = new FileResource("../nc_weather/2014/weather-2014-05-01.csv");
        CSVParser parser = ab.getCSVParser();
        CSVRecord aaa = lowestRecord(parser,"TemperatureF","-9999");
        System.out.println(aaa.get("TimeEDT")+"is" +aaa.get("TemperatureF") );
        
    
    }
    String fileWithColdestTemperature (){
        DirectoryResource ab = new DirectoryResource();
        String name = null;
        CSVRecord hour = null;
        CSVRecord coldestHour = null;
        CSVRecord brev = null;
        for(File f : ab.selectedFiles()){
            hour = lowestRecord(new FileResource(f.toString()).getCSVParser(),"TemperatureF","-9999");
            //System.out.println("colddadasdad was in file" +hour.get("TemperatureF")+"  " + f.toString());
            coldestHour = compare(hour,coldestHour,"TemperatureF");
            if(coldestHour != brev){
                name = f.toString();
                brev=coldestHour;
                System.out.println(coldestHour.get("DateUTC"));
                
            }
            
        }
        return name;
        
    }
    void testFileWithColdestTemperature(){
        String day = fileWithColdestTemperature();
        System.out.println("coldest day was in file" +day);
        System.out.println("coldest temperature was" +lowestRecord(new FileResource(day).getCSVParser(),"TemperatureF","-9999").get("TemperatureF"));
    }
    void testLowestHumidityInFile(){
        FileResource ab = new FileResource("../nc_weather/2014/weather-2014-07-22.csv");
        CSVParser parser = ab.getCSVParser();
        CSVRecord aa = lowestRecord(parser,"Humidity","N/A");
        System.out.println(aa.get("Humidity") +"  "+ aa.get("DateUTC"));
        
    
    }
    String fileWithLowestHumidity (){
        DirectoryResource ab = new DirectoryResource();
        String name = null;
        CSVRecord hour = null;
        CSVRecord coldestHour = null;
        CSVRecord brev = null;
        for(File f : ab.selectedFiles()){
            hour = lowestRecord(new FileResource(f.toString()).getCSVParser(),"Humidity","N/A");
            
            coldestHour = compare(hour,coldestHour,"Humidity");
            if(coldestHour != brev){
                name = f.toString();
                brev=coldestHour;
                
            }
            
        }
        System.out.println(coldestHour.get("DateUTC"));
        return name;
    }
    void testFileWithLowestHumidity(){
        String day = fileWithLowestHumidity();
        System.out.println("Lowest Humidity day was in file" +day);
        System.out.println("Lowest Humidity was" +lowestRecord(new FileResource(day).getCSVParser(),"Humidity","N/A").get("Humidity"));
    }
    double averageTemperatureInFile(CSVParser parser){
     double sum = 0;
     int num = 0;
        for(CSVRecord r : parser){
            if(r.get("TemperatureF")=="-9999")
                continue;
            num++;
            sum+=Double.parseDouble(r.get("TemperatureF"));
        }
        return sum/num;
    }
    void testAverageTemperatureInFile(){
        FileResource ab = new FileResource("../nc_weather/2013/weather-2013-08-10.csv");
        CSVParser parser = ab.getCSVParser();
        System.out.println(averageTemperatureInFile(parser));
    }
    double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value){
        double sum = 0;
     int num = 0;
        for(CSVRecord r : parser){
            if(r.get("TemperatureF")=="-9999" ||Integer.parseInt(r.get("Humidity"))<value)
                continue;
            num++;
            sum+=Double.parseDouble(r.get("TemperatureF"));
        }
        if(sum==0)
            return 0;
        return sum/num;
        
    }
    void testAverageTemperatureWithHighHumidityInFile(){
        FileResource ab = new FileResource("../nc_weather/2013/weather-2013-09-02.csv");
        CSVParser parser = ab.getCSVParser();
        double v = averageTemperatureWithHighHumidityInFile(parser,80);
        if(v==0){
            System.out.println("No temperatures with that humidity");
        }
        else{
            System.out.println(v );
        }
        
    }
}
