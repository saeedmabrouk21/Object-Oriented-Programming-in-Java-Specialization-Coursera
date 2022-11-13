
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*; // import the HashMap class
import edu.duke.*;
import java.io.*;
public class WordsInFiles {
    private HashMap <String,ArrayList<String>> wordToFiles;
    public WordsInFiles(){
        wordToFiles = new HashMap<String,ArrayList<String>>();
    }
    private void addWordsFromFile (File f){
        FileResource ab = new FileResource(f);
        for(String str : ab.words()){
            if(wordToFiles.containsKey(str)){
                ArrayList al = wordToFiles.get(str);
                al.add(f.getName());
                wordToFiles.put(str,al);
            }else{
                ArrayList al = new ArrayList<String>();
                al.add(f.getName());
                wordToFiles.put(str,al);
            }
        }
    }
    public void buildWordFileMap(){
        wordToFiles.clear();
        DirectoryResource ab = new DirectoryResource();
        for(File a : ab.selectedFiles()){
            addWordsFromFile(a);
        }
        
    
    }
    public int maxNumber(){
        int maxOcc  = -1;
        for(String str : wordToFiles.keySet()){
            if(wordToFiles.get(str).size()>maxOcc){
                maxOcc=wordToFiles.get(str).size();
            }
        }
        return maxOcc;
    }
    public ArrayList wordsInNumFiles(int number){
        ArrayList words = new ArrayList();
        for(String str : wordToFiles.keySet()){
            if(wordToFiles.get(str).size()==number){
                words.add(str);
            }
        }
        return words;
    }
    public void printFilesIn (String word){
        for(String a : wordToFiles.get(word)){
            System.out.println(a);
        }
    }
    public void tester(){
        buildWordFileMap();
        System.out.println(maxNumber());
        System.out.println("----------------------------------");
        ArrayList words = wordsInNumFiles(3);
        
        for(int i = 0 ; i < words.size();i++){
            System.out.println(words.get(i));
        }
        System.out.println("----------------------------------");
        printFilesIn("cats");
    }
}
