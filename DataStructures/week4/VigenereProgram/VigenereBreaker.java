import java.util.*;
import edu.duke.*;
import java.io.File;
import java.lang.StringBuilder;
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder sb = new StringBuilder();
        for(int i = whichSlice;i<message.length();i+=totalSlices){
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker();
        //WRITE YOUR CODE HERE
        for(int i = 0 ; i < klength;i++){
            String slice = sliceString(encrypted,i,klength);
            key[i] = cc.getKey(slice);
            
        }
        return key;
    }

    
    public HashSet<String> readDictionary (FileResource fr){
        HashSet<String> hs= new HashSet<String>();
        for(String a : fr.lines()){
            hs.add(a.toLowerCase());
        }
        return hs;
    }
    public int countWords (String message , HashSet<String>hs){
        int familiarWords = 0 ;
        for(String word : message.split("\\W+")){
            if(hs.contains(word.toLowerCase())){
                familiarWords++;
            }
            
        }
        return familiarWords;
    }
    public String breakForLanguage (String encrypted,HashSet<String>dictionary,char mostCommon){
        String dec ="";
        int maxFamiliar = 0;
        int key = -1;
        for(int i = 1; i <= 100;i++){
            VigenereCipher vc = new VigenereCipher(tryKeyLength(encrypted, i, mostCommon));
            String decForSpecificKey = vc.decrypt(encrypted);
            int familair = countWords(decForSpecificKey,dictionary);
            if(familair > maxFamiliar){
                dec = decForSpecificKey;
                maxFamiliar = familair;
                key = i ;
            }
            
            
        }
        System.out.println(maxFamiliar+"###########");
        return dec;
        
    }
    public char mostCommonCharIn(HashSet<String>dictionary){
        int[] freq = new int[26];
        for(String ab : dictionary){
            for(int i = 0; i < ab.length(); i++) {
                char ch = Character.toLowerCase(ab.charAt(i));
                //System.out.println(ch-'a');
                //System.out.println(ch);
                if(ch<'a' || ch>'z')
                    continue;
                freq[ch-'a']+=1;
            
            } 
        }
        int maxf= 0;
        for(int i = 1 ; i < 26 ;i++){
            if(freq[i]>freq[maxf]){
                maxf=i;
            }
        }
        
        return (char)('a'+freq[maxf]);
    }
    public void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>>languages){
        int maxfam = 0 ;
        String decrypted="";
        String ll= "";
        for(String lang:languages.keySet()){
            char mostCommon = mostCommonCharIn(languages.get(lang));
            String dec = breakForLanguage(encrypted, languages.get(lang),mostCommon);
            int familiar = countWords(dec,languages.get(lang));
            if(familiar > maxfam){
                decrypted = dec;
                maxfam = familiar;
                ll=lang;
            }
            
        }
        System.out.println(ll);
        System.out.println(decrypted);
        
    }
    
    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource f = new FileResource();

        String fAsString = f.asString();
        
        DirectoryResource dr = new DirectoryResource();
        HashMap<String,HashSet<String>> dis = new HashMap<String,HashSet<String>>() ;
        
        for (File fi : dr.selectedFiles()) {
             HashSet<String> words = new HashSet<String>();
             FileResource fff = new FileResource("M:\\SoftwareCourses\\Object-Oriented-Programming-in-Java-Specialization-Coursera\\DataStructures\\week4\\VigenereProgram\\dictionaries\\"+fi.getName());
             for(String a : fff.lines()){
                 words.add(a);
             }
             //System.out.println(fi.toString());
             dis.put(fi.getName(),words);

        }
        breakForAllLangs(fAsString, dis);
        //System.out.println(dis.get("French"));
        //VigenereCipher vc = new VigenereCipher(arr);
        //System.out.println(dec);
    }
}
