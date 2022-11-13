/**
 * Reads a chosen CSV file of our preferences and prints each field.
 * 
 * @author Duke Software Team
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class FirstCSVExample {
    public void readFood() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser){
            System.out.print(record.get("Name") + " ");
            System.out.print(record.get("Favorite Color") + " ");
            System.out.println(record.get("Favorite Food"));
        }
    }
    public void tester (){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser,"Nauru"));
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser,"cotton","flowers");
        parser = fr.getCSVParser();
        
        System.out.println(numberOfExporters(parser,"cocoa"));
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
       
    }
    public String countryInfo (CSVParser parser,String country){

        for(CSVRecord a:parser){
            if(a.get("Country").contains(country)){
                return (a.get("Country")+": "+a.get("Exports")+": "+a.get("Value (dollars)"));
                
                
            }
        }
        return "NOT FOUND";
    }
    public void listExportersTwoProducts (CSVParser parser ,String exportItem1,String exportItem2){
        
        for(CSVRecord a:parser){
            if(a.get("Exports").contains(exportItem1) && a.get("Exports").contains(exportItem2)){
                System.out.println(a.get("Country"));
                
                
            }
        }
    }
    public int numberOfExporters(CSVParser parser,String exportItem){
        int exporters = 0;
        for(CSVRecord a:parser){
            if(a.get("Exports").contains(exportItem) ){
                exporters++;
                
                
            }
        }
        return exporters;
        
    }
    public void bigExporters (CSVParser parser ,String amount){
        for(CSVRecord a:parser){
            if(a.get("Value (dollars)").length()>amount.length()){
                System.out.println (a.get("Country")+" "+a.get("Value (dollars)"));
                
                
            }
        }
    }
}

