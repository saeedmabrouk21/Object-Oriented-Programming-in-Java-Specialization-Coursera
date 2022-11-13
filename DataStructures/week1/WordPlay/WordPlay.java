
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel (char ch){
        if(ch == 'a' ||ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' )
            return true;
            
        return false;
        
    }
    public String replaceVowels (String phrase, char ch){
        StringBuilder ss = new StringBuilder (phrase);
        for(int i = 0 ; i < phrase.length();i++){
            if(isVowel(Character.toLowerCase(ss.charAt(i)))){
                ss.setCharAt(i,ch);
        }
        }
        return ss.toString();
    }
    public String emphasize(String phrase ,char ch){
        StringBuilder ss = new StringBuilder (phrase);
        for(int i = 0 ; i < phrase.length();i++){
            if(ss.charAt(i) == ch){
                if(i%2 == 0)
                {
                    ss.setCharAt(i,'*');
                }else
                {
                    ss.setCharAt(i,'+');
                }
            }
        }
        return ss.toString();
        
        
    }
    
    
    
    public void testIsVowel (){
        System.out.println(isVowel('f'));
        System.out.println(isVowel('a'));
    
    }
    public void testReplaceVowels(){
        System.out.println(replaceVowels("saeed Fares",'%'));
        
    }
    public void testEmphasize(){
        System.out.println(emphasize("Mary Bella Abracadabra",'a'));
    }
}
